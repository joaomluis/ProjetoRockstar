package GUI;

import BackEnd.RockStar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    private JPanel currentPanel;
    private JPanel panelContainer;
    private CardLayout cardLayout;
    private MenuInicial menuInicial;
    private LogInMusico logInMusico;
    private LogInCliente logInCliente;
    private RegistarCliente registarCliente;
    private RegistarMusico registarMusico;
    protected RockStar rockStar;



    public GUI(RockStar rockStar) {

        this.rockStar = rockStar;

        ImageIcon logoRockStar = new ImageIcon("logo_2.png");

        //Criação da frame inicial
        setTitle("RockStar.Inc");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(logoRockStar.getImage());


        // Criação de card layout para implementar os vários paineis
        panelContainer = new JPanel();
        cardLayout = new CardLayout();
        panelContainer.setLayout(cardLayout);

        //Inicialização dos vários paineis
        menuInicial = new MenuInicial(this);
        logInMusico = new LogInMusico(this);
        logInCliente = new LogInCliente(this);
        registarCliente = new RegistarCliente(this);
        registarMusico = new RegistarMusico(this);

        //Junção dos paines ao card layout
        panelContainer.add(menuInicial, "Menu Inicial");
        panelContainer.add(logInMusico, "Log In Musico");
        panelContainer.add(logInCliente, "Log In Cliente");
        panelContainer.add(registarCliente, "Registar Cliente");
        panelContainer.add(registarMusico, "Registar Musico");

        add(panelContainer);
        setCurrentPanel(menuInicial);
        cardLayout.show(panelContainer, "Menu Inicial");
        setVisible(true);
    }

    private void setCurrentPanel(JPanel currentPanel) {
        this.currentPanel = currentPanel;
    }

    protected void showMusicianLogIn() {
        setCurrentPanel(logInMusico);
        cardLayout.show(panelContainer, "Log In Musico");
    }

    protected void showClientLogIn() {
        setCurrentPanel(logInCliente);
        cardLayout.show(panelContainer, "Log In Cliente");
    }
    protected void showCreateClient() {
        setCurrentPanel(registarCliente);
        cardLayout.show(panelContainer, "Registar Cliente");
    }
    protected void showCreateMusician() {
        setCurrentPanel(registarMusico);
        cardLayout.show(panelContainer, "Registar Musico");
    }
    protected void showMainMenu() {
        setCurrentPanel(menuInicial);
        cardLayout.show(panelContainer, "Menu Inicial");
    }

    public RockStar getRockStar() {
        return rockStar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
