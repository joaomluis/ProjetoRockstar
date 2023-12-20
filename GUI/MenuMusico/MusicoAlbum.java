package GUI.MenuMusico;

import BackEnd.Musica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MusicoAlbum extends JPanel implements ActionListener {
    private DefaultTableModel tabelaDefault;
    private FrameMusic frameMusic;
    private JTable tabela;
    private JButton adicionar;
    private ArrayList<Musica> musicas;
    private int sortByNameOrder = 1;


    public MusicoAlbum(FrameMusic frameMusic) {
        this.frameMusic = frameMusic;
        setLayout(new BorderLayout());
        this.musicas = new ArrayList<>(); //ler o ficheiro

//        ////////////////////////////////////////PAINEL SUPERIOR////////////////////////////////////////////////////////
        JPanel painelSuperior = new JPanel(); // Inicializa o painel superior
        painelSuperior.setBackground(new Color(124, 98, 171));
        painelSuperior.setPreferredSize(new Dimension(0, 20)); //Altura do painel Superior
        painelSuperior.setLayout(null);

        //Criar elementos Painel superior
        JLabel titulo = new JLabel("Album");  //Subsituir o Nome do usuario
        //Add elementos ao Painel superior
        painelSuperior.add(titulo).setBounds(380,0,120,20);
        ////////////////////////////////////////PAINEL CENTRAL////////////////////////////////////////////////////////
        // Impede alterações na tabela
        tabelaDefault = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Define as colunas da tabela
        tabelaDefault.addColumn("Titulo");
        tabelaDefault.addColumn("Artista");
        tabelaDefault.addColumn("Preço");


        // Adiciona as músicas ao modelo de tabela
        for (Musica musica : musicas) {
            Object[] musicaObjeto = {musica.getTittle(), musica.getArtist()}; //falta preço
            tabelaDefault.addRow(musicaObjeto);
        }

        // Cria a tabela com o modelo
        tabela = new JTable(tabelaDefault);

        // Define o tamanho das colunas
        tabela.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(200);
        // Impede a movimentação das colunas.
        tabela.getTableHeader().setReorderingAllowed(false);

        // SCROLL
        JScrollPane scrollPane = new JScrollPane(tabela);

        // ADD scroll ao Panel
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Define as margens
        scrollPane.setBackground(Color.BLUE);
        scrollPane.setBackground(new Color(124, 98, 171));

        ////////////////////////////////////////PAINEL EAST////////////////////////////////////////////////////////
        JPanel painelEast = new JPanel();    //Inicializa o painel central
        painelEast.setLayout(new GridLayout(15,1));
        //Largura do painel East
        painelEast.setPreferredSize(new Dimension(100, 0));

        //Criar elementos Painel EAST
        adicionar = new JButton("Adicionar");
        adicionar.addActionListener(this);  //adicionar o botão ao actionListener
        //Add elementos ao Painel Central
        painelEast.add(adicionar).setBounds(0,0,300,40);

        painelEast.setBackground(new Color(124, 98, 171));

        ////////////////////////////////////////CONTAINER////////////////////////////////////////////////////////
        Container contentPane = frameMusic.getContentPane();
        contentPane.setLayout(new BorderLayout());


        add(painelSuperior, BorderLayout.NORTH);
        add(painelEast, BorderLayout.EAST);
        add(scrollPane, BorderLayout.CENTER);


        //instrução da localização no layout
        contentPane.setBackground(new Color(124, 98, 171));

        setVisible(true);
    }
    private void ordenarNome() {
        Collections.sort(musicas, new Comparator<Musica>() {
            @Override
            public int compare(Musica musica1, Musica musica2) {
                int result = musica1.getTittle().compareTo(musica2.getTittle());
                return result * sortByNameOrder; // Multiplica pelo valor da variável de controle para inverter a ordem se necessário
            }
        });
        sortByNameOrder *= -1; // Inverte o valor da variável de controle para a próxima ordenação

        // Limpa o modelo de tabela
        tabelaDefault.setRowCount(0);

        // Adiciona as músicas ordenadas ao modelo de tabela
        for (Musica musica : musicas) {
            Object[] rowData = {musica.getTittle(), musica.getArtist()};
            tabelaDefault.addRow(rowData);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == adicionar){
            JOptionPane.showMessageDialog(MusicoAlbum.this, "Botão 'Adicionar' pressionado.");
        }
    }
}



