package GUI.MenuMusico;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuInicialMusico extends JPanel implements ActionListener {
    private JLabel tittle;
    private JButton musicas;
    private JButton meusAlbuns;
    private FrameMusico frameMusico;
    private JButton botaoPesquisa;
    private JPanel painelSuperior;
    private JPanel painelCentral;
    private JButton estatistica;
    private JTextField pesquisa;

    public MenuInicialMusico(FrameMusico frameMusico) {
        this.frameMusico = frameMusico;

        setLayout(null);
        setBackground(new Color(124, 98, 171));

        painelCentral = new JPanel();
        painelCentral.setLayout(null);
        //Label principal do painel
        tittle = new JLabel("Welcome to RockStar");
        tittle.setForeground(new Color(198,107,61));
        tittle.setFont(new Font("Arial", Font.BOLD, 33));
        tittle.setBounds(180, 55, 400, 40);

        //botão para aceder ao menu das músicas do músico
        musicas = new JButton("Minhas músicas");
        musicas.setBounds(210, tittle.getY() + 85, 280, 35);
        musicas.setForeground(Color.black);
        musicas.setFont(new Font("Arial", Font.BOLD, 15));
        musicas.setFocusable(false);
        musicas.addActionListener(this);

        //botão para aceder ao menu das playlists do cliente
        meusAlbuns = new JButton("Meus Albuns");
        meusAlbuns.setBounds(musicas.getX(), musicas.getY() + 50, 280, 35);
        meusAlbuns.setForeground(Color.black);
        meusAlbuns.setFont(new Font("Arial", Font.BOLD, 15));
        meusAlbuns.setFocusable(false);
        meusAlbuns.addActionListener(this);

        //botão para mostrar as estatisticas
        estatistica = new JButton("Estatistica");
        estatistica.setBounds(meusAlbuns.getX(), meusAlbuns.getY() + 150, 280, 35);
        estatistica.setForeground(Color.black);
        estatistica.setFont(new Font("Arial", Font.BOLD, 15));
        estatistica.setFocusable(false);
        estatistica.addActionListener(this);

        painelCentral.setBackground(new Color(124, 98, 171));

        add(tittle);
        add(musicas);
        add(meusAlbuns);
        add(estatistica);
//
        //Criar elementos Painel superior
        pesquisa = new JTextField();
        botaoPesquisa = new JButton("\uD83D\uDD0D"); //"Símbolo de Lupa" e tem o código Unicode U+1F50D
        //Add elementos ao Painel superior
        add(pesquisa).setBounds(200,0,300,40); // Adiciona a barra de pesquisa ao painel superior
        add(botaoPesquisa).setBounds(pesquisa.getX()+pesquisa.getWidth()+10,pesquisa.getY(),30,pesquisa.getHeight());
//
//        ////////////////////////////////////////CONTAINER////////////////////////////////////////////////////////
        Container contentPane = frameMusico.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(new Color(124, 98, 171));

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == meusAlbuns) {
            frameMusico.showMusicoMeusAlbuns();
        }
        else if (e.getSource() == musicas) {
            frameMusico.showMusicoMusicas();
        }
        else if (e.getSource() == estatistica) {
        }
    }
}



