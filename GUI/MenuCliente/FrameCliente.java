package GUI.MenuCliente;

import javax.swing.*;
import java.awt.*;

public class FrameCliente extends JFrame {

    private JButton homeButton;
    private JPanel homeButtonPanel;
    public void interfaceClient() {

        ImageIcon logoRockStar = new ImageIcon("logo_2.png");

        //especificações básicas do frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setTitle("RockStar.Inc - Client");
        setIconImage(logoRockStar.getImage());
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        homeButton = new JButton();
        homeButton.setBounds(0, 0, 40, 40);


        homeButtonPanel = new JPanel();
        homeButtonPanel.setBackground(new Color(20,11,88));
        homeButtonPanel.setBounds(0, 0, 50, 50);
        homeButtonPanel.add(homeButton);


        addPanelToFrame();
        add(homeButtonPanel);

        revalidate();
    }

    //Método que cria uma instancia do painel principal e adiciona ao frame do cliente
    protected void addPanelToFrame() {
        MenuInicial menuInicial = new MenuInicial();
        menuInicial.mainPanel();
        setContentPane(menuInicial);
    }

    public static void main(String[] args) {

        FrameCliente frameCliente = new FrameCliente();
        frameCliente.interfaceClient();

    }
}
