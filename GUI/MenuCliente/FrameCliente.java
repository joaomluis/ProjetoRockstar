package GUI.MenuCliente;

import javax.swing.*;
import java.awt.*;

public class FrameCliente extends JFrame {

    private JButton homeButton;
    private JPanel homeButtonPanel;
    private JPanel panelContainer;
    private CardLayout cardLayout;
    private MenuInicial menuInicial;
    private MyMusic myMusic;
    private JPanel currentPanel;
    

    public void interfaceClient() {

        ImageIcon logoRockStar = new ImageIcon("logo_2.png");

        //especificações básicas do frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setTitle("RockStar.Inc - Client");
        setIconImage(logoRockStar.getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        homeButton = new JButton();
        homeButton.setBounds(0, 0, 40, 40);


        homeButtonPanel = new JPanel();
        homeButtonPanel.setBackground(new Color(20,11,88));
        homeButtonPanel.setBounds(0, 0, 50, 50);
        homeButtonPanel.add(homeButton);

        panelContainer = new JPanel();
        cardLayout = new CardLayout();
        panelContainer.setLayout(cardLayout);

        menuInicial = new MenuInicial(this);
        myMusic = new MyMusic(this);


        panelContainer.add(menuInicial, "Menu Inicial");
        panelContainer.add(myMusic, "MyMusic");

        add(homeButtonPanel);
        add(panelContainer);

        revalidate();
    }

    protected void showMyMusicPanel() {
        setCurrentPanel(myMusic);
        cardLayout.show(panelContainer, "MyMusic");
    }

    private void setCurrentPanel(JPanel currentPanel) {
        this.currentPanel = currentPanel;
    }

    public static void main(String[] args) {

        FrameCliente frameCliente = new FrameCliente();
        frameCliente.interfaceClient();

    }
}
