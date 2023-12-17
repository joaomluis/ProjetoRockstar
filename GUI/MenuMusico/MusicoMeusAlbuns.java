package GUI.MenuMusico;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MusicoMeusAlbuns extends JFrame implements ActionListener {
    private final JButton retroceder;
    private JButton botao1;
    private JButton botao2;
    private JButton botao3;
    private JTextField pesquisa;

    public MusicoMeusAlbuns() {
        //Janela principal
        setTitle("Menu Musico");
        setDefaultCloseOperation(3);//=JFrame.EXIT_ON_CLOSE
        setSize(500, 500);
        setResizable(false);

        ////////////////////////////////////////PAINEL SUPERIOR////////////////////////////////////////////////////////
        JPanel painelSuperior = new JPanel(); // Inicializa o painel superior
        painelSuperior.setBackground(new Color(124, 98, 171));
        painelSuperior.setPreferredSize(new Dimension(0, 50)); //Altura do painel Superior
        painelSuperior.setLayout(null);

        //Criar elementos Painel superior
        pesquisa = new JTextField();
        retroceder = new JButton("\u2190"); //"Símbolo de Lupa" e tem o código Unicode U+1F50D
        JLabel username = new JLabel("nomeUsuario");  //Subsituir o Nome do usuario
        //Add elementos ao Painel superior
        painelSuperior.add(retroceder).setBounds(10,10,30,30); // Adiciona a barra de pesquisa ao painel superior
        painelSuperior.add(username).setBounds(380,0,120,20);

        ////////////////////////////////////////PAINEL CENTRAL////////////////////////////////////////////////////////
        JPanel painelCentral = new JPanel();    //Inicializa o painel central
        painelCentral.setBackground(new Color(142, 126, 178));
        painelCentral.setLayout(null);

        //Criar elementos Painel Central
        botao1 = new JButton("Meus Albuns");
        botao2 = new JButton("Musicas");
        botao3 = new JButton("Estatistica");
        //Add elementos ao Painel Central
        painelCentral.add(botao1).setBounds(100,10,300,40);
        painelCentral.add(botao2).setBounds(botao1.getX(),botao1.getY()+botao1.getHeight()+10,300,40);
        painelCentral.add(botao3).setBounds(botao2.getX(),botao2.getY()+botao2.getHeight()+150,300,40);

        ////////////////////////////////////////CONTAINER////////////////////////////////////////////////////////
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(painelSuperior, "North"); //instrução da localização no layout
        contentPane.add(painelCentral, "Center"); //instrução da localização no layout
        setLocationRelativeTo((Component)null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MusicoMeusAlbuns();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}



