package BackEnd;

import GUI.GUI;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RockStar {

    private static ArrayList<Cliente> baseDadosClientes;
    private ArrayList<Musica> baseDadosMusicas;

    public RockStar() {
        baseDadosClientes = new ArrayList<>();
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
                    addCliente(novoCliente);
                    salvarClientesNoArquivo("baseDadosRockstar.ser");
                    return 1;
                } else if (tipo == Tipo.MUSICO) {
                    Musico novoMusico = new Musico(username, password, pin);
                    return 1;
                }
            } else {
                return 2;
            }
        }
        return 0;
    }

    /**
     * Adiciona o novo cliente à ArrayList da classe
     * @param cliente
     */
    private static void addCliente(Cliente cliente) {
        baseDadosClientes.add(cliente);
    }

        /**
         * Guarda o novo objeto de tipo Cliente na base de dados da plataforma
         * @param clientes
         * @param ficheiro
         */
    private static void saveClients(List<Cliente> clientes, String ficheiro) {

        List<Cliente> clientesExistentes = getClientList(ficheiro);

        if(clientesExistentes != null) {
            clientesExistentes.addAll(clientes);
            clientes = clientesExistentes;
        }

        try {
            FileOutputStream fos = new FileOutputStream(ficheiro);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clientes);
            oos.close();
            fos.close();
            System.out.println(ficheiro + " serialized");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static void salvarClientesNoArquivo(String ficheiro) {
        saveClients(baseDadosClientes, ficheiro);
    }

    /**
     * Método que lê o ficheiro onde estão guardados os dados das contas de Cliente criadas e converte
     * esses objetos de volta para uma lista de clientes
     * @param ficheiro
     * @return
     */
    private static List<Cliente> getClientList(String ficheiro) {
        List<Cliente> clientes = new ArrayList<>();

        try {
            FileInputStream fos = new FileInputStream(ficheiro);
            ObjectInputStream ois = new ObjectInputStream(fos);
            clientes = (List<Cliente>) ois.readObject();
        } catch (EOFException e) {

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    private static boolean verificaUsername(String username) {

        List<Cliente> clientes = getClientList("baseDadosRockstar.ser");

        for (Cliente cliente: clientes) {
            if(cliente.getUsername().equals(username)) {
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
}
