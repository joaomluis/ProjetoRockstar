package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistarCliente {

    private JPanel createClientPanel;
    private JButton cancelButton;
    private JButton createButton;
    private JLabel tittleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    protected void createClientPanel(JFrame frame, GUI gui) {

        createClientPanel = new JPanel();
        createClientPanel.setLayout(null);
        createClientPanel.setBackground(new Color(124, 98, 171));

        tittleLabel = new JLabel();
        tittleLabel.setText("Criar uma conta");
        tittleLabel.setBounds(138, 50, 223, 40);
        tittleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        tittleLabel.setForeground(Color.black);

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
        usernameLabel.setForeground(Color.black);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 13));
        usernameLabel.setBounds(usernameField.getX() - 80, usernameField.getY(), 70, 28);

        //label da passaword
        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setForeground(Color.black);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 13));
        passwordLabel.setBounds(passwordField.getX() - 80, passwordField.getY(), 70, 28);

        //botão de confirmar registo
        createButton = new JButton();
        createButton.setBounds(100, 280, 115, 32);
        createButton.setText("Registar");
        createButton.setFocusable(false);
        createButton.setFont(new Font("Arial", Font.BOLD, 15));
        createButton.setForeground(Color.black);

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
                gui.retrocederPainel();
            }
        });

        createClientPanel.add(cancelButton);
        createClientPanel.add(createButton);
        createClientPanel.add(tittleLabel);
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