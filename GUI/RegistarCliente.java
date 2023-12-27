package GUI;

import BackEnd.RockStar;
import BackEnd.Tipo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegistarCliente {

    private JPanel createClientPanel;
    private JButton cancelButton;
    private JButton createButton;
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private String inputUsername;
    private String inputPassword;
    private RockStar rockStar;

    protected void createClientPanel(JFrame frame, GUI gui) {

        rockStar = new RockStar();
        createClientPanel = new JPanel();
        createClientPanel.setLayout(null);
        createClientPanel.setBackground(new Color(77, 24, 28));

        titleLabel = new JLabel();
        titleLabel.setText("Criar uma conta");
        titleLabel.setBounds(138, 50, 223, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(229, 141, 46));

        // caixa de texto para o username
        usernameField = new JTextField();
        usernameField.setBounds(230, 145, 150, 28);
        usernameField.setFont(new Font("Arial", Font.BOLD, 13));

        //caixa de texto para a password
        passwordField = new JPasswordField();
        passwordField.setBounds(230, usernameField.getY() + 45, 150, 28);
        passwordField.setFont(new Font("Arial", Font.BOLD, 13));


        // label do Username
        usernameLabel = new JLabel();
        usernameLabel.setText("Username");
        usernameLabel.setForeground(new Color(229, 141, 46));
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 13));
        usernameLabel.setBounds(usernameField.getX() - 80, usernameField.getY(), 70, 28);

        //label da passaword
        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setForeground(new Color(229, 141, 46));
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 13));
        passwordLabel.setBounds(passwordField.getX() - 80, passwordField.getY(), 70, 28);

        //botão de confirmar registo
        createButton = new JButton();
        createButton.setBounds(100, 280, 115, 32);
        createButton.setText("Registar");
        createButton.setFocusable(false);
        createButton.setFont(new Font("Arial", Font.BOLD, 15));
        createButton.setForeground(Color.black);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inputUsername = usernameField.getText();
                char[] passwordChar = passwordField.getPassword();
                inputPassword = new String(passwordChar);

                if (rockStar.createUser(inputUsername, inputPassword, "0000", Tipo.CLIENTE) == 1) {
                    JOptionPane.showMessageDialog(frame, "Conta criada com sucesso.");
                } else if (rockStar.createUser(inputUsername, inputPassword, "0000", Tipo.CLIENTE) == 2) {
                    JOptionPane.showMessageDialog(frame, "Username já está em uso.");
                } else if (rockStar.createUser(inputUsername, inputPassword, "0000", Tipo.CLIENTE) == 3) {
                    JOptionPane.showMessageDialog(frame, "Deixou um campo vazio.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Algo correu mal, tente novamente.");
                }
            }
        });

        //botão de cancelar e retrocede para o painel anterior
        cancelButton = new JButton();
        cancelButton.setBounds(285, 280, 115, 32);
        cancelButton.setText("Cancelar");
        cancelButton.setFocusable(false);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 15));
        cancelButton.setForeground(Color.black);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        createClientPanel.add(cancelButton);
        createClientPanel.add(createButton);
        createClientPanel.add(titleLabel);
        createClientPanel.add(usernameField);
        createClientPanel.add(passwordField);
        createClientPanel.add(usernameLabel);
        createClientPanel.add(passwordLabel);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(createClientPanel);
        frame.revalidate();
        frame.repaint();
    }
}
