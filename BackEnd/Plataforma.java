package BackEnd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Plataforma implements Serializable {
    private ArrayList<User> baseDadosUser;
    private ArrayList<Musica> baseDadosMusicas;
    private HashMap<Musica,Integer> baseDadosMusicasVendidas;
    private User userLogado;

    public Plataforma() {
        this.baseDadosUser = new ArrayList<>();
        //this.baseDadosMusicos = new ArrayList<>();
        this.baseDadosMusicas = new ArrayList<>();
        this.baseDadosMusicasVendidas = new HashMap<>();
    }

    /**
     * Verifica a existencia do user na lista de users registados.
     * @param username do cliente/musico
     * @return true se o cliente/musico existe, false caso contrário
     */
    public boolean userExistente(String username) {
        //Verifica se o cliente ja existe
        for(User u: baseDadosUser){
            if(u.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    /**
     * Cria cliente. Verifica se já existe ou não.
     * @param username nome do novo cliente
     * @param password password do novo cliente
     * @return true se o cliente foi criado com sucesso, false caso contrário
     */
    public boolean criarUser(String username,
                             String password,
                             String pin,
                             Tipo tipo) {
        //Se o user já existe, retorna falso na criação de novo user com o mesmo nome.
        if(userExistente(username)) {
            return false;
        }else {
        //Caso o user ainda não exista, adiciona-o na base de dados de acordo com o seu tipo.
            if (tipo == Tipo.CLIENTE) {
                baseDadosUser.add(new Cliente(username, password));
                return true;
            } else if (tipo == Tipo.MUSICO) {
                baseDadosUser.add(new Musico(username, password, pin));
                return true;
            }
        }
        return false;
    }
    /**
     * Verifica se há algum user logado
     * @return true se houver um user logado, false caso contrário
     */
    public boolean userEstaLogado() {
        if(userLogado != null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Realiza o login de um user verificando a validade das credenciais.
     * Verifica se o user é um cliente ou um musico e procede ao login.
     * @return true se o login foi bem-sucedido, false caso contrário
     */
    public boolean fazerLogin(String username, String password, String pin) {
        if(!userEstaLogado()) {
            for (User u : baseDadosUser) {
                if (u instanceof Musico) {
                    if (u.getUsername().equals(username) && u.getPassword().equals(password) && ((Musico) u).getPin().equals(pin)) {
                        userLogado = (Musico) u;
                        return true;
                    }
                } else if (u instanceof Cliente) {
                    if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                        userLogado = (Cliente) u;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Realiza o logout do user atualmente logado.
     */
    public void fazerLogout(){
        userLogado = null;
    }

    public User getUserLogado() {
        return userLogado;
    }
}
