package GUI.MenuCliente;

import javax.swing.*;

public class MenuPrincipal {

    private JFrame frame;
    private JPanel mainMenu;

    public void interfaceClient() {

        ImageIcon logoRockStar = new ImageIcon("logo_2.png");

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 500);
        frame.setTitle("RockStar.Inc");
        frame.setIconImage(logoRockStar.getImage());
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }


}
