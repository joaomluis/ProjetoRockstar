package GUI.MenuMusico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMusic extends JFrame implements ActionListener {

    private MusicoEditar musicoEditar;
    private MusicoAlbum musicoAlbum;
    private MusicoMusicas musicoMusicas;
    private MainMusic mainMusic;
    private Painel1 painel1;
    private MusicoMeusAlbuns musicoMeusAlbuns;
    private JLabel username;
    private JButton back;
    private JButton home;
    private CardLayout cardLayout;
    private JPanel panelCont;
    private JPanel painelAtual;

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
        mainMusic = new MainMusic(this);
        painel1 = new Painel1(this);
        musicoMeusAlbuns = new MusicoMeusAlbuns(this);
        musicoMusicas = new MusicoMusicas(this);
        musicoAlbum = new MusicoAlbum(this);
        musicoEditar = new MusicoEditar(this);

        // Adicione os painéis ao painel de conteúdo (todos os paineis serão adicionados aqui)
        panelCont.add(mainMusic, "MainMusic");
        panelCont.add(painel1, "Painel1");
        panelCont.add(musicoMeusAlbuns, "MeusAlbuns");
        panelCont.add(musicoMusicas, "MusicoMusicas");
        panelCont.add(musicoAlbum, "MusicoAlbum");
        panelCont.add(musicoEditar, "MusicoEditar");


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

        northPanel.setBackground(new Color(124, 98, 171));

        showMainMusic(); //apresentar o 1º painel

        setVisible(true); // Torna o frame visível

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==home){
            cardLayout.show(panelCont, "MainMusic");
            setPainelAtual(mainMusic);
        }
        else if(e.getSource()==back){
            if(painelAtual == musicoMeusAlbuns){
                cardLayout.show(panelCont, "MainMusic");
                setPainelAtual(mainMusic);          //atualiza o painel atual

            }
            else if(painelAtual == painel1){
                cardLayout.show(panelCont, "MeusAlbuns");
                setPainelAtual(musicoMeusAlbuns);   //atualiza o painel atual

            }
            else if(painelAtual == musicoMusicas) {
                cardLayout.show(panelCont, "MainMusic");
                setPainelAtual(mainMusic);          //atualiza o painel atual
            }
            else if(painelAtual == musicoAlbum) {
                cardLayout.show(panelCont, "MeusAlbuns");
                setPainelAtual(musicoMeusAlbuns);   //atualiza o painel atual
            }
            else if(painelAtual == musicoEditar) {
                cardLayout.show(panelCont, "MusicoMusicas");
                setPainelAtual(musicoMusicas);   //atualiza o painel atual
            }
        }
    }

    /**
     * Métodos show, são compostos por um setPainelAtual para atualizar o painel, e por um show do cardLayout para mostrar o painel.
     */
    public void showMainMusic(){
        setPainelAtual(mainMusic);
        cardLayout.show(panelCont, "MainMusic");
    }
    public void showPainel1(){
        setPainelAtual(painel1);
        cardLayout.show(panelCont, "Painel1");
    }
    public void showMusicoMeusAlbuns(){
        setPainelAtual(musicoMeusAlbuns);     //atualiza o painel atual
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
    public void showMusicoEditar(){
        setPainelAtual(musicoEditar);
        cardLayout.show(panelCont,"MusicoEditar");
    }


    /**
     * Serve para atualizar o painel com o painel desejado com argumento
     * @param painelAtual
     */
    public void setPainelAtual(JPanel painelAtual) {
        this.painelAtual = painelAtual;
    }

    public static void main(String[] args) {
        new FrameMusic();
    }
}

