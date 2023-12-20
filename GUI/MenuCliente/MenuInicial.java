package GUI.MenuCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicial extends JPanel implements ActionListener {

    private JButton myMusic;
    private JButton myPlaylists;
    private JButton createPlaylist;
    private JButton purchaseHistory;
    private JButton logOut;
    private JButton store;
    private JLabel tittle;
    private JLabel usernameLabel;
    private FrameCliente frameCliente;

    protected MenuInicial(FrameCliente frameCliente) {

        this.frameCliente = frameCliente;

        setLayout(null);
        setBackground(new Color(20,64,88));

        //Label principal do painel
        tittle = new JLabel();
        tittle.setText("Welcome to RockStar");
        tittle.setForeground(new Color(198,107,61));
        tittle.setFont(new Font("Arial", Font.BOLD, 33));
        tittle.setBounds(110, 55, 400, 40);


        //Botão para aceder à loja
        store = new JButton();
        store.setFocusable(false);
        store.setBounds(610, 15, 58, 25);
        store.setText("Loja");
        store.setFont(new Font("Arial", Font.BOLD, 10));
        store.setForeground(Color.black);

        //botão para aceder ao menu das músicas do cliente
        myMusic = new JButton();
        myMusic.setBounds(213, tittle.getY() + 85, 280, 35);
        myMusic.setForeground(Color.black);
        myMusic.setFont(new Font("Arial", Font.BOLD, 15));
        myMusic.setText("Minhas músicas");
        myMusic.setFocusable(false);
        myMusic.addActionListener(this);

        //botão para aceder ao menu das playlists do cliente
        myPlaylists = new JButton();
        myPlaylists.setBounds(myMusic.getX(), myMusic.getY() + 50, 280, 35);
        myPlaylists.setForeground(Color.black);
        myPlaylists.setFont(new Font("Arial", Font.BOLD, 15));
        myPlaylists.setText("Minhas playlists");
        myPlaylists.setFocusable(false);

        // botão para mostrar pop up que vai gerar playlist
        createPlaylist = new JButton();
        createPlaylist.setBounds(myPlaylists.getX(), myPlaylists.getY() + 50, 280, 35);
        createPlaylist.setForeground(Color.black);
        createPlaylist.setFont(new Font("Arial", Font.BOLD, 15));
        createPlaylist.setText("Gerar playlist");
        createPlaylist.setFocusable(false);

        //botão para aceder ao histórico de compras
        purchaseHistory = new JButton();
        purchaseHistory.setBounds(createPlaylist.getX(), createPlaylist.getY() + 50, 280, 35);
        purchaseHistory.setForeground(Color.black);
        purchaseHistory.setFont(new Font("Arial", Font.BOLD, 15));
        purchaseHistory.setText("Histórico de compras");
        purchaseHistory.setFocusable(false);

        //botão para fazer log out
        logOut = new JButton();
        logOut.setBounds(purchaseHistory.getX(), purchaseHistory.getY() + 50, 280, 35);
        logOut.setForeground(Color.black);
        logOut.setFont(new Font("Arial", Font.BOLD, 15));
        logOut.setText("Log out");
        logOut.setFocusable(false);

        add(tittle);
        add(store);
        add(myMusic);
        add(myPlaylists);
        add(createPlaylist);
        add(purchaseHistory);
        add(logOut);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myMusic) {
            frameCliente.showMyMusicPanel();
        }
    }
}