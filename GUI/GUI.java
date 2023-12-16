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
        labelWelcomeText.setForeground(Color.BLACK);
        labelWelcomeText.setBorder(new LineBorder(Color.BLACK));
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
                    System.out.println("log in cliente");
                } else if (radioButtonMusician.isSelected()) {
                    System.out.println("log in musico");
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
                    System.out.println("Criar conta cliente");
                } else if (radioButtonMusician.isSelected()) {
                    System.out.println("Criar conta músico");
                }
            }
        });

        ButtonGroup userGroup = new ButtonGroup();
        //Botão seleção interface Cliente
        radioButtonClient = new JRadioButton();
        radioButtonClient.setBounds(160, 280, 77, 30);
        radioButtonClient.setText("Cliente");
        radioButtonClient.setFont(new Font("Arial", Font.BOLD, 15));
        radioButtonClient.setForeground(Color.black);
        radioButtonClient.setBackground(new Color(124, 98, 171));
        radioButtonClient.setFocusable(false);
        radioButtonClient.addActionListener(this);

        //Botão seleção interface Musico
        radioButtonMusician = new JRadioButton();
        radioButtonMusician.setBounds(260, 280, 77, 30);
        radioButtonMusician.setText("Músico");
        radioButtonMusician.setFont(new Font("Arial", Font.BOLD, 15));
        radioButtonMusician.setForeground(Color.black);
        radioButtonMusician.setBackground(new Color(124, 98, 171));
        radioButtonMusician.setFocusable(false);

        userGroup.add(radioButtonClient);
        userGroup.add(radioButtonMusician);

        //Criação do painel e adição dos diferentes componentes 
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(124, 98, 171));
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
}
