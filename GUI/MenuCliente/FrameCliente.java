package GUI.MenuCliente;

import javax.swing.*;

public class FrameCliente extends JFrame {

    public void interfaceClient() {

        ImageIcon logoRockStar = new ImageIcon("logo_2.png");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 600);
        setTitle("RockStar.Inc");
        setIconImage(logoRockStar.getImage());
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);



        addPanelToFrame();
        setVisible(true);
    }

    protected void addPanelToFrame() {
        MenuInicial menuInicial = new MenuInicial();
        menuInicial.mainPanel();
        setContentPane(menuInicial);
    }
}
