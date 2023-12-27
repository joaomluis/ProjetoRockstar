package GUI.MenuMusico;

import BackEnd.RockStar;
import GUI.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MusicoMenuInicial extends JPanel implements ActionListener {
    private JButton logOut;
    private JLabel tittle;
    private JButton musicas;
    private JButton meusAlbuns;
    private FrameMusico frameMusico;
    private JButton pesquisa;
    private JPanel painelCentral;
    private JButton estatistica;

    public MusicoMenuInicial(FrameMusico frameMusico) {
        this.frameMusico = frameMusico;

        setLayout(null);
        setBackground(new Color(77, 24, 28));

        painelCentral = new JPanel();
        painelCentral.setLayout(null);
        //Label principal do painel
        tittle = new JLabel("Welcome to RockStar");
        tittle.setForeground(new Color(255,255,255));
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

        pesquisa = new JButton("Pesquisar \uD83D\uDD0D"); //"Símbolo de Lupa" e tem o código Unicode U+1F50D
        pesquisa.setBounds(meusAlbuns.getX(), meusAlbuns.getY() + 50, 280, 35);
        pesquisa.setForeground(Color.black);
        pesquisa.setFont(new Font("Arial", Font.BOLD, 15));
        pesquisa.setFocusable(false);
        pesquisa.addActionListener(this);
        painelCentral.setBackground(new Color(77, 24, 28));

        //botão para mostrar as estatisticas
        estatistica = new JButton("Estatistica");
        estatistica.setBounds(meusAlbuns.getX(), pesquisa.getY() + 50, 280, 35);
        estatistica.setForeground(Color.black);
        estatistica.setFont(new Font("Arial", Font.BOLD, 15));
        estatistica.setFocusable(false);
        estatistica.addActionListener(this);

        //botão para mostrar as estatisticas
        logOut = new JButton("Log Out");
        logOut.setBounds(meusAlbuns.getX(), estatistica.getY() + 50, 280, 35);
        logOut.setForeground(Color.black);
        logOut.setFont(new Font("Arial", Font.BOLD, 15));
        logOut.setFocusable(false);
        logOut.addActionListener(this);


        add(tittle);
        add(musicas);
        add(meusAlbuns);
        add(pesquisa);
        add(estatistica);
        add(logOut);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        RockStar rockStar = frameMusico.getRockStar();

        if (e.getSource() == meusAlbuns) {
            frameMusico.showMusicoMeusAlbuns();
        }
        else if (e.getSource() == musicas) {
            frameMusico.showMusicoMusicas();
        }
        else if (e.getSource() == pesquisa) {
            frameMusico.showMusicoPesquisa();
        }
        else if (e.getSource() == estatistica) {
            frameMusico.showEstatistica();
        }
        else if(e.getSource() == logOut){
            rockStar.logOut();
            frameMusico.dispose();
            GUI gui = new GUI(rockStar);
        }
    }
}



