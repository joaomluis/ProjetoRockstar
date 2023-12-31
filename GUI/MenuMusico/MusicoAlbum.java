package GUI.MenuMusico;

import BackEnd.Album;
import BackEnd.Musica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MusicoAlbum extends JPanel implements ActionListener {
    private JPanel painelEast;
    private JScrollPane scrollPane;
    private JPanel painelSuperior;
    private DefaultTableModel tabelaDefault;
    private FrameMusico frameMusico;
    private JTable tabela;
    private JButton adicionar;
    private ArrayList<Musica> musicas;
    private Album albumSelecionado;


    public MusicoAlbum(FrameMusico frameMusico) {
        this.frameMusico = frameMusico;
        setLayout(new BorderLayout());
        this.musicas = new ArrayList<>(); //ler o ficheiro

//        ////////////////////////////////////////PAINEL SUPERIOR////////////////////////////////////////////////////////
        painelSuperior = new JPanel(); // Inicializa o painel superior
        painelSuperior.setBackground(new Color(77, 24, 28));
        painelSuperior.setPreferredSize(new Dimension(0, 40)); //Altura do painel Superior
        painelSuperior.setLayout(null);

        //Criar elementos Painel superior
        JLabel titulo = new JLabel("Album");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(new Color(255,255,255));
        painelSuperior.add(titulo).setBounds(250, 5, 250, 30);
        add(painelSuperior, BorderLayout.NORTH);

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
        add(scrollPane, BorderLayout.CENTER);

        ////////////////////////////////////////PAINEL EAST////////////////////////////////////////////////////////
        painelEast = new JPanel();    //Inicializa o painel central
        painelEast.setLayout(null);
        //Largura do painel East
        painelEast.setPreferredSize(new Dimension(150, 0));

        //Criar elementos Painel EAST
        adicionar = new JButton("Adicionar");
        adicionar.addActionListener(this);  //adicionar o botão ao actionListener
        //Add elementos ao Painel Central
        painelEast.add(adicionar).setBounds(0,125,120,35);

        painelEast.setBackground(new Color(77, 24, 28));

        add(painelEast, BorderLayout.EAST);

        setAlbumSelecionado(albumSelecionado);
        carregarMusicasDoMusico();
        setVisible(true);
    }
    private void atualizarTabelaMusicas() {
        // Limpar os dados existentes na tabela
        tabelaDefault.setRowCount(0);

        // Adicionar as músicas do músico à tabela
        for (Musica musica : musicas) {
            Object[] rowData = {musica.getTitle(), musica.getGenre(), musica.getPreco(), musica.isVisibilidade()};
            tabelaDefault.addRow(rowData);
        }

        // Atualizar a exibição da tabela
        tabela.repaint();
    }
    public void carregarMusicasDoMusico() {
        // Limpar a lista de músicas
        musicas.clear();

        if (albumSelecionado != null) {
            ArrayList<Musica> musicasDoAlbum = albumSelecionado.getMusicas();

            // Adicionar as músicas do álbum à lista de músicas do MusicoMusicas
            musicas.addAll(musicasDoAlbum);
        }

        // Atualizar a exibição da tabela de músicas
        atualizarTabelaMusicas();
    }
    public void setAlbumSelecionado(Album albumSelecionado) {
        this.albumSelecionado = albumSelecionado;
        atualizarTabelaMusicas(); // Atualiza as músicas exibidas
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == adicionar){

            //new AdicionarMusicaAlbum(frameMusico,frameMusico.getRockStar());

            carregarMusicasDoMusico();
            atualizarTabelaMusicas();
        }
    }
}



