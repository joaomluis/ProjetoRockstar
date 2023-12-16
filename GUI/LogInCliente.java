package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInCliente {

    private JPanel logInPanel;
    private JLabel username;
    private JLabel password;
    private JTextField campoUsername;
    private  JPasswordField campoPassword;
    private JButton logInButton;
    private JButton cancelButton;

    protected void painelLogInCliente(JFrame frame, GUI gui) {

        logInPanel = new JPanel();
        logInPanel.setLayout(null);
        logInPanel.setBackground(new Color(124, 98, 171));

        // botão que cancela tarefa e volta para o painel anterior
        cancelButton = new JButton();
        cancelButton.setBounds(285, 200, 115, 32);
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


        frame.getContentPane().removeAll();
        frame.getContentPane().add(logInPanel);
        frame.revalidate();
        frame.repaint();
    }
}
