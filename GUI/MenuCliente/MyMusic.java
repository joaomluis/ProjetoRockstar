package GUI.MenuCliente;

import BackEnd.Musica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMusic extends JPanel implements ActionListener {

    private FrameCliente frameCliente;
    private JList<Musica> musicList;
    private JButton returnButton;
    private JButton removeMusic;
    private JButton rateMusic;
    private JLabel username;
    private JLabel panelTittle;

    public MyMusic(FrameCliente frameCliente) {

        this.frameCliente = frameCliente;

        setLayout(null);
        setBackground(new Color(20, 64, 88));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
