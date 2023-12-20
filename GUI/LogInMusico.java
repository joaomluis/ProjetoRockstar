package GUI;
import BackEnd.Musico;
import BackEnd.User;
import GUI.MenuMusico.FrameMusic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInMusico {

    private JPanel logInPanel;
    private JLabel title;
    private JLabel subtitle;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel pinLabel;
    private JTextField usernameField;
    private  JPasswordField passwordField;
    private JPasswordField pinField;
    private JButton logInButton;
    private JButton cancelButton;
    private Musico[] musicos;

    protected void painelLogInMusico(JFrame frame, GUI gui) {

        musicos = new Musico[] {
                new Musico("musico1", "password1", "1"),
                new Musico("musico2", "password2", "2"),
                new Musico("3", "3", "3")
        };

        logInPanel = new JPanel();
        logInPanel.setLayout(null);
        logInPanel.setBackground(new Color(77, 24, 28));

        // titulo principal do painel
        title = new JLabel();
        title.setText("RockStar.Inc");
        title.setForeground(new Color(229, 141, 46));
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setBounds(138, 30, 223, 40);

        //subtitulo do painel, contem slogan
        subtitle = new JLabel();
        subtitle.setText("Ready to Rock your world!");
        subtitle.setForeground(new Color(229, 141, 46));
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

        //caixa de texto para o Pin
        pinField = new JPasswordField();
        pinField.setBounds(230, passwordField.getY() + 45, 150, 28);
        pinField.setFont(new Font("Arial", Font.BOLD, 13));

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

        //label do pin
        pinLabel = new JLabel();
        pinLabel.setText("Pin");
        pinLabel.setForeground(new Color(229, 141, 46));
        pinLabel.setFont(new Font("Arial", Font.BOLD, 13));
        pinLabel.setBounds(pinField.getX() - 40, pinField.getY(), 40, 28);

        //botão para avançar com o log in
        logInButton = new JButton();
        logInButton.setBounds(100, 295, 115, 32);
        logInButton.setText("Log In");
        logInButton.setFocusable(false);
        logInButton.setFont(new Font("Arial", Font.BOLD, 15));
        logInButton.setForeground(Color.black);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String pin = String.valueOf(pinField.getPassword());

                if (validateCredentials(username, password, pin)) {
                    // Credenciais válidas
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!"); //placeholder
                    frame.dispose();
                    FrameMusic frameMusic = new FrameMusic();

                } else {
                    // Credenciais inválidas
                    JOptionPane.showMessageDialog(null, "Credenciais inválidas. Tente novamente."); //placeholder
                }
            }
        });

        // botão que cancela tarefa e volta para o painel anterior
        cancelButton = new JButton();
        cancelButton.setBounds(285, logInButton.getY(), 115, 32);
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
        logInPanel.add(pinField);
        logInPanel.add(usernameLabel);
        logInPanel.add(passwordLabel);
        logInPanel.add(pinLabel);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(logInPanel);
        frame.revalidate();
        frame.repaint();
    }
    private boolean validateCredentials(String username, String password, String pin) {
        for (Musico musico: musicos) {
            if (musico.getUsername().equals(username) && musico.getPassword().equals(password) && musico.getPin().equals(pin)) {
                return true; // Credenciais válidas
            }
        }
        return false; // Credenciais inválidas
    }
}