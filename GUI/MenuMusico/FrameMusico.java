package GUI.MenuMusico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMusico extends JFrame implements ActionListener {

    private MusicoEditar musicoEditar;
    private MusicoAlbum musicoAlbum;
    private MusicoMusicas musicoMusicas;
    private MenuInicialMusico menuInicialMusico;
    private MusicoMeusAlbuns musicoMeusAlbuns;
    private JLabel username;
    private JButton back;
    private JButton home;
    private CardLayout cardLayout;
    private JPanel panelCont;
    private JPanel painelAtual;

    public FrameMusico(){

        ImageIcon logoRockStar = new ImageIcon("logo_2.png");

        //especificações básicas do frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        menuInicialMusico = new MenuInicialMusico(this);
        musicoMeusAlbuns = new MusicoMeusAlbuns(this);
        musicoMusicas = new MusicoMusicas(this);
        musicoAlbum = new MusicoAlbum(this);
        musicoEditar = new MusicoEditar(this);

        // Adicione os painéis ao painel de conteúdo (todos os paineis serão adicionados aqui)
        panelCont.add(menuInicialMusico, "MainMusic");
        panelCont.add(musicoMeusAlbuns, "MeusAlbuns");
        panelCont.add(musicoMusicas, "MusicoMusicas");
        panelCont.add(musicoAlbum, "MusicoAlbum");
        panelCont.add(musicoEditar, "MusicoEditar");


        // Adicione os paineis de conteúdo ao frame. Os inseridos anteriormente.
        add(panelCont);

        //NESTA FRAME //////////////////////////////////////////////////////////////////////////////////////////////////
        // Cria botões sempre visiveis nesta frame
        home = new JButton("Home");
        home.setFocusable(false);
        back = new JButton("<-");
        back.setFocusable(false);
        username = new JLabel("username");
        username.setFont(new Font("Arial", Font.BOLD, 12));
        home.addActionListener(this);
        back.addActionListener(this);

        // Crie um painel para os botões e adicione-os ao frame
        JPanel northPanel = new JPanel();
        northPanel.setLayout(null);
        northPanel.setPreferredSize(new Dimension(0, 40));

        // Adicione os botões ao painel de botões
        // Define as coordenadas e o dimensoes dos botões e label.
        northPanel.add(back).setBounds(10, 5, 60, 25);
        northPanel.add(home).setBounds(back.getX() + 70, back.getY(), 60, 25);
        northPanel.add(username).setBounds(150, 5, 200, 25);

        // Adicione o painel de botões ao frame
        add(northPanel, BorderLayout.NORTH);
        northPanel.setBackground(new Color(124, 98, 171));
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==home){
            cardLayout.show(panelCont, "MainMusic");
            setPainelAtual(menuInicialMusico);
        }
        else if(e.getSource()==back){
            if(painelAtual == musicoMeusAlbuns){
                cardLayout.show(panelCont, "MainMusic");
                setPainelAtual(menuInicialMusico);          //atualiza o painel atual

            }
            else if(painelAtual == musicoMusicas) {
                cardLayout.show(panelCont, "MainMusic");
                setPainelAtual(menuInicialMusico);          //atualiza o painel atual
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
        setPainelAtual(menuInicialMusico);
        cardLayout.show(panelCont, "MainMusic");
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
        new FrameMusico();
    }
}

