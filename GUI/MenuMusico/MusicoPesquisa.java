package GUI.MenuMusico;

import BackEnd.Musica;
import GUI.MenuMusico.PopUps.AdicionarMusica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MusicoPesquisa extends JPanel implements ActionListener {
    private JTextField barraPesquisa;
    private JComboBox<String> dropdown;
    private JPanel painelCentralSuperior;
    private JPanel painelCentral;
    private JPanel painelEast;
    private JScrollPane scrollPane;
    private JPanel painelSuperior;
    private DefaultTableModel tabelaDefault;
    private FrameMusico frameMusico;
    private JTable tabela;
    private JButton pesquisar;
    private ArrayList<Musica> musicas;


    public MusicoPesquisa(FrameMusico frameMusico) {
        this.frameMusico = frameMusico;
        setLayout(new BorderLayout());
        this.musicas = new ArrayList<>(); //ler o ficheiro

//        ////////////////////////////////////////PAINEL SUPERIOR////////////////////////////////////////////////////////
        painelSuperior = new JPanel(null); // Inicializa o painel superior
        painelSuperior.setBackground(new Color(77, 24, 28));
        painelSuperior.setPreferredSize(new Dimension(0, 40)); //Altura do painel Superior

        //Criar elementos Painel superior
        JLabel titulo = new JLabel("Pesquisa");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(new Color(255,255,255));
        painelSuperior.add(titulo).setBounds(250, 5, 250, 30);
        add(painelSuperior, BorderLayout.NORTH);

        ////////////////////////////////////////PAINEL CENTRAL////////////////////////////////////////////////////////
        // Impede alterações na tabela
        painelCentral = new JPanel(new BorderLayout());
        painelCentralSuperior = new JPanel(null);
        painelCentralSuperior.setPreferredSize(new Dimension(0, 50));
        painelCentralSuperior.setBackground(new Color(77, 24, 28));
        dropdown = new JComboBox<>(new String[]{"Nome", "Genero"});
        dropdown.addActionListener(this);
        barraPesquisa = new JTextField();
        dropdown.addActionListener(this);
        painelCentralSuperior.add(dropdown).setBounds(30,0,200,35);
        painelCentralSuperior.add(barraPesquisa).setBounds(dropdown.getX()+dropdown.getWidth()+15,0,280,35);

        tabelaDefault = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Define as colunas da tabela
        tabelaDefault.addColumn("Titulo");
        tabelaDefault.addColumn("Gênero");
        tabelaDefault.addColumn("Produtor");

//        // Adiciona as músicas ao modelo de tabela
//        for (Musica musica : musicas) {
//            Object[] musicaObjeto = {musica.getTittle(), musica.getArtist()}; //falta preço
//            tabelaDefault.addRow(musicaObjeto);
//        }

        // Cria a tabela com o modelo
        tabela = new JTable(tabelaDefault);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(200);
        // Impede a movimentação das colunas.
        tabela.getTableHeader().setReorderingAllowed(false);
        // SCROLL
        scrollPane = new JScrollPane(tabela);
        // ADD scroll ao Panel
        scrollPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Define as margens
        scrollPane.setBackground(new Color(77, 24, 28));

        painelCentral.add(scrollPane, BorderLayout.CENTER);
        painelCentral.add(painelCentralSuperior, BorderLayout.NORTH);
        add(painelCentral,BorderLayout.CENTER);

        ////////////////////////////////////////PAINEL EAST////////////////////////////////////////////////////////
        painelEast = new JPanel(null);    //Inicializa o painel central
        painelEast.setPreferredSize(new Dimension(150, 0));

        //Criar elementos Painel EAST
        pesquisar = new JButton("Pesquisar");
        pesquisar.addActionListener(this);  //adicionar o botão ao actionListener
        //Add elementos ao Painel Central
        painelEast.add(pesquisar).setBounds(0,0,120,35);
        painelEast.setBackground(new Color(77, 24, 28));
        add(painelEast, BorderLayout.EAST);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pesquisar) {
            String catgoriaAPesquisar = (String) dropdown.getSelectedItem();
            String strAPesquisar = barraPesquisa.getText();
        }
    }
}


