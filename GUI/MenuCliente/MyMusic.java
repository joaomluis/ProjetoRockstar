package GUI.MenuCliente;

import BackEnd.Musica;

import javax.swing.*;
import java.awt.*;

public class MyMusic extends JPanel {

    private JList<Musica> musicList;
    private JButton returnButton;
    private JButton removeMusic;
    private JButton rateMusic;
    private JLabel username;
    private JLabel panelTittle;

    protected void myMusicPanel(JFrame frame) {

        setLayout(null);
        setBackground(new Color(20,64,88));

        frame.getContentPane().removeAll();
        frame.getContentPane().add(this);
        frame.revalidate();
        frame.repaint();
    }
    
}
