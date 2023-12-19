package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistarMusico {

    private JPanel createMusicianPanel;
    private JButton cancelButton;
    private JButton createButton;
    private JLabel tittleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel pinLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField pinField;

    protected void createMusicianPanel (JFrame frame, GUI gui) {

        createMusicianPanel = new JPanel();
        createMusicianPanel.setLayout(null);
        createMusicianPanel.setBackground(new Color(77, 24, 28));

        // titulo principal do painel
        tittleLabel = new JLabel();
        tittleLabel.setText("Criar uma conta");
        tittleLabel.setForeground(new Color(229, 141, 46));
        tittleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        tittleLabel.setBounds(138, 30, 223, 40);

        // caixa de texto para o username
        usernameField = new JTextField();
        usernameField.setBounds(230, 115, 150, 28);
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
        createButton = new JButton();
        createButton.setBounds(100, 295, 115, 32);
        createButton.setText("Registar");
        createButton.setFocusable(false);
        createButton.setFont(new Font("Arial", Font.BOLD, 15));
        createButton.setForeground(Color.black);

        // botão que cancela tarefa e volta para o painel anterior
        cancelButton = new JButton();
        cancelButton.setBounds(285, createButton.getY(), 115, 32);
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
        createMusicianPanel.add(cancelButton);
        createMusicianPanel.add(createButton);
        createMusicianPanel.add(tittleLabel);
        createMusicianPanel.add(usernameField);
        createMusicianPanel.add(passwordField);
        createMusicianPanel.add(pinField);
        createMusicianPanel.add(usernameLabel);
        createMusicianPanel.add(passwordLabel);
        createMusicianPanel.add(pinLabel);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(createMusicianPanel);
        frame.revalidate();
        frame.repaint();
    }


}
