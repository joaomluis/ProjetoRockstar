package GUI.MenuMusico;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MusicoMeusAlbuns extends JPanel implements ActionListener {
    private FrameMusic frameMusic;
    private JTable tabela;
    private JButton ver;
    private JButton criar;
    private JButton botao3;
    private JTextField pesquisa;

    public MusicoMeusAlbuns(FrameMusic frameMusic) {
        this.frameMusic = frameMusic;
        setLayout(new BorderLayout());
        setBackground(new Color(124, 98, 171));

//        ////////////////////////////////////////PAINEL SUPERIOR////////////////////////////////////////////////////////
        JPanel painelSuperior = new JPanel(); // Inicializa o painel superior
        painelSuperior.setBackground(new Color(124, 98, 171));
        painelSuperior.setPreferredSize(new Dimension(0, 20)); //Altura do painel Superior
        painelSuperior.setLayout(null);

        //Criar elementos Painel superior
        JLabel titulo = new JLabel("Meus Albuns");  //Subsituir o Nome do usuario
        //Add elementos ao Painel superior
        painelSuperior.add(titulo).setBounds(380,0,120,20);
        ////////////////////////////////////////PAINEL CENTRAL////////////////////////////////////////////////////////
        JPanel painelCentral = new JPanel();


        String[][] musica = {
                {"Killing", "FF","25"},
                {"Blow", "Eva","14"},
                {"Legendary", "Skillet Album","22"}
        };
        String[] columnNames = {"Nome","Album", "Preço"};
        tabela = new JTable(musica, columnNames);
        JScrollPane scrollPane = new JScrollPane(tabela);
        painelCentral.setLayout(new BorderLayout());

        painelCentral.add(scrollPane, BorderLayout.CENTER);


        ////////////////////////////////////////PAINEL EAST////////////////////////////////////////////////////////
        JPanel painelEast = new JPanel();    //Inicializa o painel central
        painelEast.setBackground(new Color(142, 126, 178));
        painelEast.setLayout(new GridLayout(15,1));
        //Largura do painel East
        painelEast.setPreferredSize(new Dimension(100, 0));

        //Criar elementos Painel Central
        ver = new JButton("Ver");
        ver.addActionListener(this);    //adicionar o botão ao actionListener
        criar = new JButton("Criar");
        criar.addActionListener(this);  //adicionar o botão ao actionListener
        //Add elementos ao Painel Central
        painelEast.add(ver).setBounds(0,0,300,40);
        painelEast.add(criar).setBounds(ver.getX(), ver.getY()+ ver.getHeight()+10,300,40);

        ////////////////////////////////////////PAINEL WEST////////////////////////////////////////////////////////
        JPanel painelWest = new JPanel();
        painelWest.setBackground(new Color(154, 145, 178));

        ////////////////////////////////////////PAINEL SOUTH////////////////////////////////////////////////////////
        JPanel painelSouth = new JPanel();
        painelWest.setBackground(new Color(154, 145, 178));

        ////////////////////////////////////////CONTAINER////////////////////////////////////////////////////////
        Container contentPane = frameMusic.getContentPane();
        contentPane.setLayout(new BorderLayout());

        contentPane.setBackground(new Color(124, 98, 171));

        add(painelSuperior, BorderLayout.NORTH);
        add(painelWest, BorderLayout.WEST);
        add(painelSouth, BorderLayout.SOUTH);
        add(painelEast, BorderLayout.EAST);
        add(painelCentral, BorderLayout.CENTER);
        //instrução da localização no layout
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ver) {
            frameMusic.showPainel1();
        }
    }
}



