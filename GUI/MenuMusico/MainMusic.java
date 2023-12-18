package GUI.MenuMusico;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMusic extends JPanel implements ActionListener {
    private JButton musicas;
    private JButton meusAlbuns;
    private FrameMusic frameMusic;
    private JButton botaoPesquisa;
    private JPanel painelSuperior;
    private JPanel painelCentral;
    private JButton estatistica;
    private JTextField pesquisa;

    public MainMusic(FrameMusic frameMusic) {
        this.frameMusic = frameMusic;
        setLayout(new BorderLayout());
        setBackground(new Color(124, 98, 171));


//        ////////////////////////////////////////PAINEL CENTRAL////////////////////////////////////////////////////////
        painelCentral = new JPanel();    //Inicializa o painel central
        painelCentral.setLayout(null);

        //Criar elementos Painel Central
        meusAlbuns = new JButton("Meus Albuns");
        musicas = new JButton("Musicas");
        estatistica = new JButton("Estatistica");
        //Add elementos ao Painel Central
        painelCentral.add(meusAlbuns).setBounds(250,100,300,40);
        meusAlbuns.addActionListener(this);
        painelCentral.add(musicas).setBounds(meusAlbuns.getX(), meusAlbuns.getY()+ meusAlbuns.getHeight()+10,300,40);
        musicas.addActionListener(this);
        painelCentral.add(estatistica).setBounds(musicas.getX(), musicas.getY()+ musicas.getHeight()+150,300,40);
        estatistica.addActionListener(this);

        add(painelCentral,BorderLayout.CENTER);
//
//        ////////////////////////////////////////PAINEL SUPERIOR////////////////////////////////////////////////////////
        painelSuperior = new JPanel(); // Inicializa o painel superior
        painelSuperior.setBackground(new Color(124, 98, 171));
        painelSuperior.setPreferredSize(new Dimension(0, 40)); //Altura do painel Superior
        painelSuperior.setLayout(null);

        //Criar elementos Painel superior
        pesquisa = new JTextField();
        botaoPesquisa = new JButton("\uD83D\uDD0D"); //"Símbolo de Lupa" e tem o código Unicode U+1F50D
        //Add elementos ao Painel superior
        painelSuperior.add(pesquisa).setBounds(250,0,300,40); // Adiciona a barra de pesquisa ao painel superior
        painelSuperior.add(botaoPesquisa).setBounds(pesquisa.getX()+pesquisa.getWidth()+10,pesquisa.getY(),30,pesquisa.getHeight());
//
//        ////////////////////////////////////////CONTAINER////////////////////////////////////////////////////////
        Container contentPane = frameMusic.getContentPane();
        contentPane.setLayout(new BorderLayout());

        contentPane.setBackground(new Color(124, 98, 171));
        add(painelCentral, BorderLayout.CENTER);
        add(painelSuperior, BorderLayout.NORTH);
        //instrução da localização no layout
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(meusAlbuns == e.getSource()){
            frameMusic.showMusicoMeusAlbuns();
        }
    }


}



