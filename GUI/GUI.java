package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {


    private JLabel labelWelcomeText;
    private JFrame frame;
    private JPanel panel;
    private JButton logInButton;
    private JButton createAccButton;
    private JRadioButton radioButtonClient;
    private JRadioButton radioButtonMusician;
    private JPanel previousPanel;


    public GUI() {

        ImageIcon logoRockStar = new ImageIcon("logo_2.png");

        //Criação da frame inicial
        frame = new JFrame();
        frame.setTitle("RockStar.Inc");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(logoRockStar.getImage());

        //Texto da plataforma RockStar
        labelWelcomeText = new JLabel();
        labelWelcomeText.setText("RockStar.Inc");
        labelWelcomeText.setForeground(new Color(229, 141, 46));
        labelWelcomeText.setBorder(new LineBorder(new Color(229, 141, 46)));
        labelWelcomeText.setFont(new Font("Arial", Font.BOLD, 36));

        labelWelcomeText.setBounds(138, 80, 223, 40);

        // Botão de log in
        logInButton = new JButton();
        logInButton.setBounds(100, 200, 115, 32);
        logInButton.setText("Log In");
        logInButton.setFocusable(false);
        logInButton.setFont(new Font("Arial", Font.BOLD, 15));
        logInButton.setForeground(Color.black);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonClient.isSelected()) {
                    showLogInPanel();
                } else if (radioButtonMusician.isSelected()) {
                    showLogInPanelMusician();
                }
            }
        });

        //Botão de criar nova conta
        createAccButton = new JButton();
        createAccButton.setBounds(285, 200, 115, 32);
        createAccButton.setText("Criar Conta");
        createAccButton.setFocusable(false);
        createAccButton.setFont(new Font("Arial", Font.BOLD, 15));
        createAccButton.setForeground(Color.black);
        createAccButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonClient.isSelected()) {
                    showCreateClientPanel();
                } else if (radioButtonMusician.isSelected()) {
                    showCreateMusicianPanel();
                }
            }
        });

        ButtonGroup userGroup = new ButtonGroup();
        //Botão seleção interface Cliente
        radioButtonClient = new JRadioButton();
        radioButtonClient.setBounds(160, 280, 77, 30);
        radioButtonClient.setText("Cliente");
        radioButtonClient.setFont(new Font("Arial", Font.BOLD, 15));
        radioButtonClient.setForeground(new Color(229, 141, 46));
        radioButtonClient.setBackground(new Color(77, 24, 28));
        radioButtonClient.setFocusable(false);
        radioButtonClient.addActionListener(this);

        //Botão seleção interface Musico
        radioButtonMusician = new JRadioButton();
        radioButtonMusician.setBounds(260, 280, 77, 30);
        radioButtonMusician.setText("Músico");
        radioButtonMusician.setFont(new Font("Arial", Font.BOLD, 15));
        radioButtonMusician.setForeground(new Color(229, 141, 46));
        radioButtonMusician.setBackground(new Color(77, 24, 28));
        radioButtonMusician.setFocusable(false);

        userGroup.add(radioButtonClient);
        userGroup.add(radioButtonMusician);

        //Criação do painel e adição dos diferentes componentes
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(77, 24, 28));
        panel.add(labelWelcomeText);
        panel.add(logInButton);
        panel.add(createAccButton);
        panel.add(radioButtonClient);
        panel.add(radioButtonMusician);


        frame.setVisible(true);
        frame.add(panel);
        frame.revalidate();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    // Método para voltar ao painel anterior
    public void retrocederPainel() {
        if (previousPanel != null) {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(previousPanel);
            frame.revalidate();
            frame.repaint();
        }
    }

    private void showLogInPanel() {
        // Salvar o painel atual como painel anterior
        previousPanel = panel;
        // Criação e exibição do novo painel a partir de outra classe
        LogInCliente logInCliente = new LogInCliente();
        logInCliente.painelLogInCliente(frame, this);
    }

    private void showLogInPanelMusician(){
        previousPanel = panel;
        LogInMusico logInMusico = new LogInMusico();
        logInMusico.painelLogInMusico(frame, this);
    }

    private void showCreateClientPanel() {
        previousPanel = panel;
        RegistarCliente registarCliente = new RegistarCliente();
        registarCliente.createClientPanel(frame, this);
    }

    private void showCreateMusicianPanel() {
        previousPanel = panel;
        RegistarMusico registarMusico = new RegistarMusico();
        registarMusico.createMusicianPanel(frame, this);
    }



}
