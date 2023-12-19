package GUI.MenuCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuInicial extends JPanel {

    private JButton myMusic;
    private JButton myPlaylists;
    private JButton createPlaylist;
    private JButton purchaseHistory;
    private JButton logOut;
    private JButton store;
    private JLabel tittle;
    private JLabel usernameLabel;

    protected void mainPanel() {


        setLayout(null);
        setBackground(new Color(20,64,88));

        //Label principal do painel
        tittle = new JLabel();
        tittle.setText("Welcome to RockStar,");
        tittle.setForeground(new Color(198,107,61));
        tittle.setFont(new Font("Arial", Font.BOLD, 28));
        tittle.setBounds(110, 55, 600, 40);


        //Botão para aceder à loja
        store = new JButton();
        store.setFocusable(false);
        store.setBounds(610, 15, 58, 25);
        store.setText("Loja");
        store.setFont(new Font("Arial", Font.BOLD, 10));

        myMusic = new JButton();
        myMusic.setBounds(213, tittle.getY() + 85, 280, 35);
        myMusic.setText("Minhas músicas");
        myMusic.setFocusable(false);


        add(tittle);
        add(store);
        add(myMusic);

    }
}
