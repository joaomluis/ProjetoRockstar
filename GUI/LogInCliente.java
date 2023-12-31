package GUI;
import BackEnd.RockStar;
import GUI.MenuCliente.FrameCliente;
import GUI.MenuCliente.MainMenu;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LogInCliente extends JPanel implements ActionListener{

    private GUI gui;
    private JLabel title;
    private JLabel subtitle;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private  JPasswordField passwordField;
    private JButton logInButton;
    private JButton cancelButton;
    private String inputUsername;
    private String inputPassword;

    public LogInCliente(GUI gui) {

        this.gui = gui;

        setLayout(null);
        setBackground(new Color(77, 24, 28));

        // titulo principal do painel
        title = new JLabel();
        title.setText("RockStar.Inc");
        title.setForeground(new Color(229, 141, 46));
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setBounds(138, 50, 223, 40);

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

        //botão para avançar com o log in
        logInButton = new JButton();
        logInButton.setBounds(100, 280, 115, 32);
        logInButton.setText("Log In");
        logInButton.setFocusable(false);
        logInButton.setFont(new Font("Arial", Font.BOLD, 15));
        logInButton.setForeground(Color.black);
        logInButton.addActionListener(this);


        // botão que cancela tarefa e volta para o painel anterior
        cancelButton = new JButton();
        cancelButton.setBounds(285, 280, 115, 32);
        cancelButton.setText("Cancelar");
        cancelButton.setFocusable(false);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 15));
        cancelButton.setForeground(Color.black);
        cancelButton.addActionListener(this);

        add(cancelButton);
        add(title);
        add(subtitle);
        add(usernameField);
        add(logInButton);
        add(passwordField);
        add(usernameLabel);
        add(passwordLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RockStar rockStar = gui.getRockStar();

        if (e.getSource() == logInButton) {
            inputUsername = usernameField.getText();
            char[] passwordChar = passwordField.getPassword();
            inputPassword = new String(passwordChar);

            if (rockStar.fazerLogIn(inputUsername, inputPassword, "0000") == 1) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                FrameCliente frameCliente = new FrameCliente(rockStar);
                MainMenu menuPrincipal = new MainMenu(frameCliente);
                gui.dispose();
            } else if (rockStar.fazerLogIn(inputUsername, inputPassword, "0000") == 2){
                // Credenciais inválidas
                JOptionPane.showMessageDialog(gui, "Credenciais inválidas. Tente novamente."); //placeholder
            } else if (rockStar.fazerLogIn(inputUsername, inputPassword, "0000") == 3) {
                JOptionPane.showMessageDialog(gui, "Deixou um campo vazio.");
            }
        }
        if (e.getSource() == cancelButton) {
            gui.showMainMenu();
        }
    }
}
