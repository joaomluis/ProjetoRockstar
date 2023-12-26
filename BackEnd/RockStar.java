package BackEnd;

import GUI.GUI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RockStar {

    private static ArrayList<User> baseDadosUsers;
    private ArrayList<Musica> baseDadosMusicas;

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
     * Adiciona o novo cliente à ArrayList da classe
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

        List<User> clientesExistentes = getClientList(ficheiro);

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
    private static List<User> getClientList(String ficheiro) {
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

    private static boolean verificaUsername(String username) {

        List<User> users = getClientList("baseDadosRockstar.ser");

        for (User user: users) {
            if(user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static boolean verificaCampoVazio(String username, String password, String pin) {
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean contemDigitos(String input) {
        for (char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
