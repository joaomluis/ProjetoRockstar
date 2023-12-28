package GUI.MenuMusico;

import BackEnd.RockStar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMusico extends JFrame implements ActionListener {

    private MusicoEstatistica musicoEstatistica;
    private MusicoPesquisa musicoPesquisa;
    private JPanel northPanel;
    private MusicoAlbum musicoAlbum;
    private MusicoMusicas musicoMusicas;
    private MusicoMenuInicial musicoMenuInicial;
    private MusicoMeusAlbuns musicoMeusAlbuns;
    private JLabel username;
    private JButton back;
    private JButton home;
    private CardLayout cardLayout;
    private JPanel panelCont;
    private JPanel painelAtual;
    private RockStar rockStar;

    public FrameMusico(RockStar rockStar){

        this.rockStar = rockStar;

        Color fundo = new Color(77, 24, 28);
        Color letras = new Color(255,255,255);
        ImageIcon logoRockStar = new ImageIcon("logo_2.png");

        //especificações básicas do frame
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(700, 550);
        setTitle("RockStar.Inc - Musico");
        setIconImage(logoRockStar.getImage());
        setLocationRelativeTo(null);
        setResizable(false);

        // Criação de card layout para implementar os vários paineis
        panelCont = new JPanel();
        cardLayout = new CardLayout();
        panelCont.setLayout(cardLayout);

        // Cria os painéis que serão exibidos no cardLayout (todos os paineis serão criados aqui)
        musicoMenuInicial = new MusicoMenuInicial(this);
        musicoMeusAlbuns = new MusicoMeusAlbuns(this);
        musicoMusicas = new MusicoMusicas(this);
        musicoAlbum = new MusicoAlbum(this);
        musicoPesquisa = new MusicoPesquisa(this);
        musicoEstatistica = new MusicoEstatistica(this);

        // Adicione os painéis ao painel de conteúdo (todos os paineis serão adicionados aqui)
        panelCont.add(musicoMenuInicial, "MainMusic");
        panelCont.add(musicoMeusAlbuns, "MeusAlbuns");
        panelCont.add(musicoMusicas, "MusicoMusicas");
        panelCont.add(musicoAlbum, "MusicoAlbum");
        panelCont.add(musicoPesquisa, "MusicoPesquisa");
        panelCont.add(musicoEstatistica,"Estatistica");

        // Adicione os paineis de conteúdo ao frame. Os inseridos anteriormente.
        add(panelCont);

        //NESTA FRAME //////////////////////////////////////////////////////////////////////////////////////////////////
        // Cria botões sempre visiveis nesta frame
        home = new JButton("⌂");
        home.setFont(new Font("Arial", Font.BOLD, 26));
        home.setFocusable(false);
        back = new JButton("←");
        back.setFont(new Font("Arial", Font.BOLD, 26));
        back.setFocusable(false);
        username = new JLabel("username");
        username.setFont(new Font("Arial", Font.BOLD, 12));
        username.setText(rockStar.getUserAtivo().getUsername());
        username.setForeground(new Color(255,255,255));
        home.addActionListener(this);
        back.addActionListener(this);

        // Crie um painel para os botões e adicione-os ao frame
        northPanel = new JPanel();
        northPanel.setLayout(null);
        northPanel.setPreferredSize(new Dimension(0, 40));

        // Adicione os botões ao painel de botões
        // Define as coordenadas e o dimensoes dos botões e label.
        northPanel.add(back).setBounds(10, 5, 60, 25);
        northPanel.add(home).setBounds(back.getX() + 70, back.getY(), 60, 25);
        northPanel.add(username).setBounds(150, 5, 200, 25);

        // Adicione o painel de botões ao frame
        add(northPanel, BorderLayout.NORTH);
        northPanel.setBackground(fundo);
        setVisible(true);
    }

    public RockStar getRockStar() {
        return rockStar;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==home){
            cardLayout.show(panelCont, "MainMusic");
            setPainelAtual(musicoMenuInicial);
        }
        else if(e.getSource()==back){
            if(painelAtual == musicoMeusAlbuns){
                cardLayout.show(panelCont, "MainMusic");
                setPainelAtual(musicoMenuInicial);

            }
            else if(painelAtual == musicoMusicas) {
                cardLayout.show(panelCont, "MainMusic");
                setPainelAtual(musicoMenuInicial);
            }
            else if(painelAtual == musicoAlbum) {
                cardLayout.show(panelCont, "MeusAlbuns");
                setPainelAtual(musicoMeusAlbuns);
            }
            else if(painelAtual == musicoPesquisa) {
                cardLayout.show(panelCont, "MainMusic");
                setPainelAtual(musicoMenuInicial);
            }
            else if(painelAtual == musicoEstatistica) {
                cardLayout.show(panelCont, "MainMusic");
                setPainelAtual(musicoMenuInicial);
            }
        }
    }

    /**
     * Métodos show, são compostos por um setPainelAtual para atualizar o painel, e por um show do cardLayout para mostrar o painel.
     */
    public void showMainMusic(){
        setPainelAtual(musicoMenuInicial);
        cardLayout.show(panelCont, "MainMusic");
    }
    public void showMusicoMeusAlbuns(){
        setPainelAtual(musicoMeusAlbuns);
        cardLayout.show(panelCont, "MeusAlbuns");
    }
    public void showMusicoMusicas(){
        setPainelAtual(musicoMusicas);
        cardLayout.show(panelCont,"MusicoMusicas");
    }
    public void showMusicoAlbum(){
        setPainelAtual(musicoMusicas);
        cardLayout.show(panelCont,"MusicoMusicas");
    }
    public void showMusicoPesquisa() {
        setPainelAtual(musicoPesquisa);
        cardLayout.show(panelCont,"MusicoPesquisa");
    }
    public void showEstatistica() {
        setPainelAtual(musicoEstatistica);
        cardLayout.show(panelCont,"Estatistica");
    }


    /**
     * Serve para atualizar o painel com o painel desejado com argumento
     * @param painelAtual
     */
    public void setPainelAtual(JPanel painelAtual) {
        this.painelAtual = painelAtual;
    }

}

