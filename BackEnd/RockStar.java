package BackEnd;

import GUI.GUI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RockStar {

    private static ArrayList<User> baseDadosUsers;
    private ArrayList<Musica> baseDadosMusicas;
    private static User userAtivo;

    public RockStar() {
        baseDadosUsers = new ArrayList<>();
        baseDadosMusicas = new ArrayList<>();
        new GUI();

    }

    /**
     * Cria um objeto novo do tipo Cliente através do input colocado nas JTextFields da interface,
     * posteriormente chama o método addCliente para adicionar à ArrayLista da classe e por fim
     * chama o método saveClient para guardar na base de dados.
     * @param username
     * @param password
     * @return O objeto do novo Cliente
     */
    public static int createUser(String username, String password, String pin, Tipo tipo) {

        if (verificaCampoVazio(username, password, pin)) { // se houver um campo vazio
            return 3;
        } else {
            if (!verificaUsername(username)) { // se não há nome igual
                if (tipo == Tipo.CLIENTE) {
                    Cliente novoCliente = new Cliente(username, password);
                    addUser(novoCliente);
                    salvarUsersNoArquivo("baseDadosRockstar.ser");
                    return 1;
                } else if (tipo == Tipo.MUSICO) {
                    if (contemDigitos(pin)) { // se o pin é só digitos de 0 a 9
                        Musico novoMusico = new Musico(username, password, pin);
                        addUser(novoMusico);
                        salvarUsersNoArquivo("baseDadosRockstar.ser");
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
    private static void addUser(User user) {
        baseDadosUsers.add(user);
    }

        /**
         * Guarda o novo objeto de tipo User na base de dados da plataforma
         * @param users
         * @param ficheiro
         */
    private static void saveUsers(List<User> users, String ficheiro) {

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

    private static void salvarUsersNoArquivo(String ficheiro) {
        saveUsers(baseDadosUsers, ficheiro);
    }

    /**
     * Método que lê o ficheiro onde estão guardados os dados das contas de Cliente criadas e converte
     * esses objetos de volta para uma lista de clientes
     * @param ficheiro
     * @return
     */
    private static List<User> getUserList(String ficheiro) {
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

    /**
     * Metodo chamado durante o registo de conta que vai verificar no ficheiro se já existe
     * algum objeto do tipo User com o username insirdo no JTextField de username.
     * @param username
     * @return
     */
    private static boolean verificaUsername(String username) {

        List<User> users = getUserList("baseDadosRockstar.ser");

        for (User user: users) {
            if(user.getUsername().equals(username)) {
                return true;
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
    private static boolean verificaCampoVazio(String username, String password, String pin) {
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
    private static boolean contemDigitos(String input) {
        for (char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    private static boolean estaLogado() {
        if (userAtivo != null) {
            return true;
        }
        return false;
    }

    public static boolean fazerLogIn(String username, String password, String pin) {

        List<User> usersList = getUserList("baseDadosRockstar.ser");

        if (!estaLogado()) {
            for (User user : usersList) {
                if (user instanceof Cliente) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        userAtivo = (Cliente) user;
                        return true;
                    }
                } else if (user instanceof Musico) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password) && ((Musico) user).getPin().equals(pin)) {
                        userAtivo = (Musico) user;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
