package BackEnd;

import GUI.GUI;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RockStar implements Serializable {

    private ArrayList<User> baseDadosUsers;
    private ArrayList<Musica> baseDadosMusicas;
    private ArrayList<Album> baseDadosAlbuns;

    private User userAtivo;
    private GUI gui;
    private File file;
    private static final long serialVersionUID = 1325672347L;

    public RockStar(String pathName) {
        this.gui = new GUI(this);
        this.baseDadosMusicas = new ArrayList<>();
        this.baseDadosUsers = new ArrayList<>();
        this.baseDadosAlbuns = new ArrayList<>();

        file = new File(pathName);

        deserializeRockStar(file.getName());

//        Musico musico1 = new Musico("Artista1", "1", "11");
//        baseDadosUsers.add(new Musico("Artista1", "1", "11"));
//        baseDadosMusicas.add(new Musica("Musica1", musico1, "Pop", 2));
//        baseDadosMusicas.add(new Musica("Musica2", musico1, "Pop", 0));
//        baseDadosMusicas.add(new Musica("Musica3", musico1, "Pop", 0));
    }

    public ArrayList<Album> getBaseDadosAlbuns() {
        return baseDadosAlbuns;
    }

    public void getAllSongs(DefaultTableModel tableModel) {
        for (Musica musica : baseDadosMusicas) {
            boolean alreadyAdded = false;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (musica.getTitle().equals(tableModel.getValueAt(i, 0))) {
                    alreadyAdded = true;
                    break;
                }
            }
            if (!alreadyAdded) {
                Object[] row = {musica.getTitle(), musica.getArtist().getUsername(), musica.getPreco()};
                tableModel.addRow(row);
            }
        }
    }

    public ArrayList<User> getBaseDadosUsers() {
        return baseDadosUsers;
    }

    public ArrayList<Musica> getBaseDadosMusicas() {
        return baseDadosMusicas;
    }

    public void serializeRockStar(String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
            oos.close();
            fos.close();
            System.out.println(filePath + " serialized");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void deserializeRockStar(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Object obj = ois.readObject();
            if (obj instanceof RockStar) {
                RockStar loadedRockStar = (RockStar) obj;

                // Atualizando os campos da instância atual com os dados desserializados
                this.baseDadosUsers = loadedRockStar.baseDadosUsers;
                this.baseDadosMusicas = loadedRockStar.baseDadosMusicas;
                this.baseDadosAlbuns = loadedRockStar.baseDadosAlbuns;
                this.userAtivo = loadedRockStar.userAtivo;

                System.out.println("RockStar deserialized");
            } else {
                System.out.println("Failed to deserialize. Invalid data type.");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cria um objeto novo do tipo Cliente através do input colocado nas JTextFields da interface,
     * posteriormente chama o método addCliente para adicionar à ArrayLista da classe e por fim
     * chama o método saveClient para guardar na base de dados.
     * @param username
     * @param password
     * @return O objeto do novo Cliente
     */
    public int createUser(String username, String password, String pin, Tipo tipo) {

        if (verificaCampoVazio(username, password, pin)) { // se houver um campo vazio
            return 3;
        } else {
            if (!verificaUsername(username)) { // se não há nome igual
                if (tipo == Tipo.CLIENTE) {
                    Cliente novoCliente = new Cliente(username, password);
                    addUser(novoCliente);
                    //salvarUsersNoArquivo("baseDadosRockstar.ser");
                    return 1;
                } else if (tipo == Tipo.MUSICO) {
                    if (contemDigitos(pin)) { // se o pin é só digitos de 0 a 9
                        Musico novoMusico = new Musico(username, password, pin);
                        addUser(novoMusico);
                        //salvarUsersNoArquivo("baseDadosRockstar.ser");
                        return 1;
                    } else {
                        return 4;
                    }
                }
            } else {
                return 2;
            }
        }
        return 0;
    }

    /**
     * Adiciona o novo user à ArrayList da classe
     * @param user
     */
    private void addUser(User user) {
        this.baseDadosUsers.add(user);
    }

    /**
     * Guarda o novo objeto de tipo User na base de dados da plataforma
     * @param users
     * @param ficheiro
     */
    private void saveUsers(List<User> users, String ficheiro) {

        List<User> clientesExistentes = getUserList(ficheiro);

        if(clientesExistentes != null) {
            clientesExistentes.addAll(users);
            users = clientesExistentes;
        }

        try {
            FileOutputStream fos = new FileOutputStream(ficheiro);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
            fos.close();
            System.out.println(ficheiro + " serialized");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void salvarUsersNoArquivo(String ficheiro) {
        saveUsers(baseDadosUsers, ficheiro);
    }

    /**
     * Método que lê o ficheiro onde estão guardados os dados das contas de Cliente criadas e converte
     * esses objetos de volta para uma lista de clientes
     * @param ficheiro
     * @return
     */
    private List<User> getUserList(String ficheiro) {
        List<User> users = new ArrayList<>();

        try {
            FileInputStream fos = new FileInputStream(ficheiro);
            ObjectInputStream ois = new ObjectInputStream(fos);
            users = (List<User>) ois.readObject();
        } catch (EOFException e) {

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
    private List<User> getAllUsers() {
        return new ArrayList<>(baseDadosUsers);
    }


    /**
     * Metodo chamado durante o registo de conta que vai verificar no ficheiro se já existe
     * algum objeto do tipo User com o username insirdo no JTextField de username.
     * @param username
     * @return
     */
    private boolean verificaUsername(String username) {

        //List<User> users = getAllUsers();
        if(baseDadosUsers != null) {
            for (User user : baseDadosUsers) {
                if (user.getUsername().equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo chamado durante o registo de conta que verifica se algum dos campos de input estão vazios
     * impedindo o utilizador de registar conta sem preencher tudo.
     * @param username
     * @param password
     * @param pin
     * @return
     */
    private boolean verificaCampoVazio(String username, String password, String pin) {
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Método chamado no registo de conta de um Músico que verifica se o campo do pin
     * só contém digitos de 0 a 9.
     * @param input
     * @return
     */
    private boolean contemDigitos(String input) {
        for (char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    private boolean estaLogado() {
        if (userAtivo != null) {
            return true;
        }
        return false;
    }

    public int fazerLogIn(String username, String password, String pin) {

        List<User> usersList = baseDadosUsers;

        if (verificaCampoVazio(username, password, pin)) {
            return 3; //há campos vazios
        } else {
            if (!estaLogado()) {
                for (User user : usersList) {
                    if (user instanceof Cliente) {
                        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                            userAtivo = (Cliente) user;
                            return 1; //sucesso
                        }
                    } else if (user instanceof Musico) {
                        if (user.getUsername().equals(username) && user.getPassword().equals(password) && ((Musico) user).getPin().equals(pin)) {
                            userAtivo = (Musico) user;
                            return 1; //sucesso
                        }
                    }
                }
            }
        }
        return 2; //credenciais incorretas
    }

    public User getUserAtivo() {
        return userAtivo;
    }

    /**
     * Verifica se o atributo userAtivo é do tipo cliente, se for dá return desse atributo como cliente
     * para poder ter acesso aos métodos do Cliente
     * @return Cliente se o atributo userAtivo for do tipo Cliente, senão return null
     */
    public Cliente getUserAtivoCliente () {
        if (userAtivo instanceof Cliente) {
            return (Cliente) userAtivo;
        }
        return null;
    }
    public Musico getUserAtivoMusico () {
        if (userAtivo instanceof Musico) {
            return (Musico) userAtivo;
        }
        return null;
    }

    public boolean addAlbum(Album album){
        ArrayList<Album> albunsDomusico = getUserAtivoMusico().getAlbuns();
        if(albunsDomusico != null){
            for(Album a : albunsDomusico){
                if(a.getTitle().equalsIgnoreCase(album.getTitle())){
                    return false;
                }
            }
        }
        baseDadosAlbuns.add(album);
        return true;
    }

    public void logOut() {
        userAtivo = null;
    }
    public boolean addMusica(Musica musica){
        ArrayList<Musica> musicasDomusico = getUserAtivoMusico().getMusicas();
        if(musicasDomusico != null){
            nomeMusicaValido(musica.getTitle());
        }
        baseDadosMusicas.add(musica);
        return true;
    }
    public boolean nomeMusicaValido(String nome){
        for(Musica m : getUserAtivoMusico().getMusicas()){
            if(m.getTitle().equalsIgnoreCase(nome)){
                return false;
            }
        }
        return true;
    }
    public int albumPorGenero(String genero){
        int albumPorGenero = 0;
        for(Album a: baseDadosAlbuns){
            if(a.getGenre().toLowerCase().equals(genero.toLowerCase())){
                albumPorGenero++;
            }
        }
        return albumPorGenero;
    }
    public String[] albunsDoMusico(Musico musico){
        int tamanhoArray = musico.getAlbuns().size()+1;
        String[] dropBoxs = new String[tamanhoArray];
        dropBoxs[0] = "Sem Album";
        int i=1;
        for(Album a : musico.getAlbuns()){
            dropBoxs[i] = a.getTitle();
            i++;
        }
        return dropBoxs;
    }
    public String[] getGenerosMusicais() {
        Genero[] generos = Genero.values();
        String[] generosMusicais = new String[generos.length];

        for (int i = 0; i < generos.length; i++) {
            generosMusicais[i] = generos[i].toString();
        }
        return generosMusicais;
    }
    public int getTotalUsers(){
        if(baseDadosUsers!=null){
            return baseDadosUsers.size();
        }
        return -1;
    }

    public int getTotalMusicos() {
        int totalMusicos=0;
        if(baseDadosUsers!=null){
            for(User u: baseDadosUsers){
                if(u instanceof Musico){
                    totalMusicos++;
                }
            }
            return totalMusicos;
        }
        return -1;
    }

    public double getValortotalMusicas() {
        double valorTotalMusicas = 0;
        if(baseDadosMusicas != null){
            for(Musica m : baseDadosMusicas){
                valorTotalMusicas += m.getPreco();
            }
            return valorTotalMusicas;
        }
        return -1;
    }
}
