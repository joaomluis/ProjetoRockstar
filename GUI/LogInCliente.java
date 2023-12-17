package GUI;
import BackEnd.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInCliente {

    private JPanel logInPanel;
    private JLabel title;
    private JLabel subtitle;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private  JPasswordField passwordField;
    private JButton logInButton;
    private JButton cancelButton;
    private User[] users;

    protected void painelLogInCliente(JFrame frame, GUI gui) {

        users = new User[] {
                new User("user1", "password1"),
                new User("user2", "password2"),
                new User("user3", "password3")
        };

        logInPanel = new JPanel();
        logInPanel.setLayout(null);
        logInPanel.setBackground(new Color(124, 98, 171));

        // titulo principal do painel
        title = new JLabel();
        title.setText("RockStar.Inc");
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setBounds(138, 50, 223, 40);

        //subtitulo do painel, contem slogan
        subtitle = new JLabel();
        subtitle.setText("Ready to Rock your world!");
        subtitle.setForeground(Color.black);
        subtitle.setFont(new Font("Arial", Font.BOLD, 24));
        subtitle.setBounds(title.getX() - 43, title.getY() + 40, 310, 30);

        // caixa de texto para o username
        usernameField = new JTextField();
        usernameField.setBounds(230, subtitle.getY() + 67, 150, 28);
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

        //botão para avançar com o log in
        logInButton = new JButton();
        logInButton.setBounds(100, 280, 115, 32);
        logInButton.setText("Log In");
        logInButton.setFocusable(false);
        logInButton.setFont(new Font("Arial", Font.BOLD, 15));
        logInButton.setForeground(Color.black);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (validateCredentials(username, password)) {
                    // Credenciais válidas
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!"); //placeholder
                    // Realizar ação após o login ser bem-sucedido
                } else {
                    // Credenciais inválidas
                    JOptionPane.showMessageDialog(null, "Credenciais inválidas. Tente novamente."); //placeholder
                }
            }
        });

        // botão que cancela tarefa e volta para o painel anterior
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

        logInPanel.add(cancelButton);
        logInPanel.add(title);
        logInPanel.add(subtitle);
        logInPanel.add(usernameField);
        logInPanel.add(logInButton);
        logInPanel.add(passwordField);
        logInPanel.add(usernameLabel);
        logInPanel.add(passwordLabel);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(logInPanel);
        frame.revalidate();
        frame.repaint();
    }
    private boolean validateCredentials(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Credenciais válidas
            }
        }
        return false; // Credenciais inválidas
    }
}
