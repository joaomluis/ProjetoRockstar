package GUI.MenuCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCliente extends JFrame implements ActionListener {

    private JButton homeButton;
    private JButton backButton;
    private JButton cartButton;
    private JLabel username;
    private JLabel balance;
    private JPanel homeButtonPanel;
    private JPanel panelContainer;
    private CardLayout cardLayout;
    private MenuInicial menuInicial;
    private MyMusic myMusic;
    private MyPlaylists myPlaylists;
    private JPanel currentPanel;


    public void interfaceClient() {

        ImageIcon logoRockStar = new ImageIcon("logo_2.png");

        //especificações básicas do frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setTitle("RockStar.Inc - Cliente");
        setIconImage(logoRockStar.getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        // Criação de card layout para implementar os vários paineis
        panelContainer = new JPanel();
        cardLayout = new CardLayout();
        panelContainer.setLayout(cardLayout);

        //Inicialização dos vários paineis
        menuInicial = new MenuInicial(this);
        myMusic = new MyMusic(this);
        myPlaylists = new MyPlaylists(this);

        //Junção dos paines ao card layout
        panelContainer.add(menuInicial, "Menu Inicial");
        panelContainer.add(myMusic, "MyMusic");
        panelContainer.add(myPlaylists, "MyPlaylists");

        //Painel que fica no topo com os botões
        homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(null);
        homeButtonPanel.setPreferredSize(new Dimension(0, 40));
        homeButtonPanel.setBackground(new Color(20, 64, 88));

        //Botão retroceder
        backButton = new JButton();
        backButton.setBounds(10, 5, 60,25);
        backButton.setText("<-");
        backButton.setFocusable(false);

        //Botão home
        homeButton = new JButton();
        homeButton.setBounds(backButton.getX() + 70, backButton.getY(), 60, 25);
        homeButton.setText("Home");
        homeButton.setFocusable(false);
        homeButton.addActionListener(this);

        //Botão carrinho de compras
        cartButton = new JButton();
        cartButton.setBounds(620, 5, 60, 25);
        cartButton.setText("Carrinho");
        cartButton.setFocusable(false);

        //Label saldo
        balance = new JLabel();
        balance.setBounds(570, 5, 60, 25);
        balance.setText("110,99€");
        balance.setFont(new Font("Arial", Font.BOLD, 12));
        balance.setForeground(new Color(198,107,61));

        //label do username
        username = new JLabel();
        username.setBounds(150, 5, 200, 25);
        username.setText("username");
        username.setFont(new Font("Arial", Font.BOLD, 12));
        username.setForeground(new Color(198,107,61));


        //Acrescentar botões à barra norte
        homeButtonPanel.add(backButton);
        homeButtonPanel.add(homeButton);
        homeButtonPanel.add(cartButton);
        homeButtonPanel.add(balance);
        homeButtonPanel.add(username);


        //Junção de componentes à frame
        add(panelContainer);
        add(homeButtonPanel, BorderLayout.NORTH);



        revalidate();
    }

    protected void showMyMusicPanel() {
        setCurrentPanel(myMusic);
        cardLayout.show(panelContainer, "MyMusic");
    }
    protected void showMyPlaylistsPanel() {
        setCurrentPanel(myPlaylists);
        cardLayout.show(panelContainer, "MyPlaylists");
    }

    private void setCurrentPanel(JPanel currentPanel) {
        this.currentPanel = currentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeButton) {
            cardLayout.show(panelContainer, "Menu Inicial");
            setCurrentPanel(menuInicial);
        }
    }

    public static void main(String[] args) {

        FrameCliente frameCliente = new FrameCliente();
        frameCliente.interfaceClient();

    }
}
