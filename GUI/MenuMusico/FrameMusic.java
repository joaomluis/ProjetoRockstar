package GUI.MenuMusico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMusic extends JFrame implements ActionListener {

    private JLabel username;
    private JButton back;
    private JButton home;
    private CardLayout cardLayout;
    private JPanel panelCont;

    public FrameMusic(){
        // Configurações da frame
        setTitle("Músico");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);    // Centraliza o frame na tela
        setResizable(false);            // Impede o redimensionamento do frame

        // Cria o painel de conteúdo com o CardLayout
        panelCont = new JPanel();
        cardLayout = new CardLayout();
        panelCont.setLayout(cardLayout);

        // Cria os painéis que serão exibidos no cardLayout (todos os paineis serão criados aqui)
        MainMusic mainMusic = new MainMusic(this);
        Painel1 painel1 = new Painel1(this);
        MusicoMeusAlbuns musicoMeusAlbuns = new MusicoMeusAlbuns(this);

        // Adicione os painéis ao painel de conteúdo (todos os paineis serão adicionados aqui)
        panelCont.add(mainMusic, "MainMusic");
        panelCont.add(painel1, "Painel1");
        panelCont.add(musicoMeusAlbuns, "MeusAlbuns");

        // Adicione os paineis de conteúdo ao frame. Os inseridos anteriormente.
        add(panelCont);

        //NESTA FRAME //////////////////////////////////////////////////////////////////////////////////////////////////
        // Cria botões sempre visiveis nesta frame
        home = new JButton("home");
        back = new JButton("<-");
        username = new JLabel("user_name");
        home.addActionListener(this);
        back.addActionListener(this);

        // Crie um painel para os botões e adicione-os ao frame
        JPanel northPanel = new JPanel();
        northPanel.setLayout(null);
        northPanel.setPreferredSize(new Dimension(0, 35));

        // Adicione os botões ao painel de botões
        // Defina as coordenadas e o dimensoes dos botões e label.
        northPanel.add(home).setBounds(80, 5, 70, 30);
        northPanel.add(back).setBounds(10, 5, 70, 30);
        northPanel.add(username).setBounds(700,5,70,30);


        // Adicione o painel de botões ao frame
        add(northPanel, BorderLayout.NORTH);

        showMainMusic();

        setVisible(true); // Torna o frame visível
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==home){
            cardLayout.show(panelCont, "MainMusic");
        }
        if(e.getSource()==back){
            cardLayout.show(panelCont, "Painel1"); //acção teste
        }
    }
    public void showMainMusic(){
        cardLayout.show(panelCont, "MainMusic");
    }
    public void showPainel1(){
        cardLayout.show(panelCont, "Painel1");
    }
    public void showMusicoMeusAlbuns(){
        cardLayout.show(panelCont, "MeusAlbuns");
    }

    public static void main(String[] args) {
        new FrameMusic();
    }
}

