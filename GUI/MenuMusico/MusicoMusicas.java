package GUI.MenuMusico;

import BackEnd.Musica;
import BackEnd.Musico;
import GUI.MenuMusico.PopUps.AdicionarMusica;
import GUI.MenuMusico.PopUps.AlterarDisponibilidade;
import GUI.MenuMusico.PopUps.AlterarNome;
import GUI.MenuMusico.PopUps.AlterarPreco;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;


public class MusicoMusicas extends JPanel implements ActionListener, MouseListener {
    private JScrollPane scrollPane;
    private JTable tabela;
    private DefaultTableModel tabelaDefault;
    private JLabel titulo;
    private JPanel painelEast;
    private JPanel painelSuperior;
    private JButton editarDisponibilidade;
    private JButton editarPreco;
    private FrameMusico frameMusico;
    private JButton editarNome;
    private JButton adicionar;
    private ArrayList<Musica> musicas;


    public MusicoMusicas(FrameMusico frameMusico) {

        this.frameMusico = frameMusico;
        setLayout(new BorderLayout());
        setBackground(new Color(77, 24, 28));

        this.musicas = new ArrayList<>(); //ler o ficheiro

//        ////////////////////////////////////////PAINEL SUPERIOR////////////////////////////////////////////////////////
        painelSuperior = new JPanel(); // Inicializa o painel superior
        painelSuperior.setBackground(new Color(77, 24, 28));
        painelSuperior.setPreferredSize(new Dimension(0, 40)); //Altura do painel Superior
        painelSuperior.setLayout(null);

        //Criar elementos Painel superior
        titulo = new JLabel("Minhas Músicas");
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

        tabelaDefault.addColumn("Titulo");
        tabelaDefault.addColumn("Genero");
        tabelaDefault.addColumn("Preço");
        tabelaDefault.addColumn("Disponibilidade");

        tabela = new JTable(tabelaDefault);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(200);

        // Impede a movimentação das colunas.
        tabela.getTableHeader().setReorderingAllowed(false);
        // Activa o TableHeader para ser executado
        tabela.getTableHeader().addMouseListener(this);
        scrollPane = new JScrollPane(tabela);

        // ADD scroll ao Panel
        scrollPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Define as margens
        scrollPane.setBackground(new Color(77, 24, 28));
        add(scrollPane, BorderLayout.CENTER);

        ////////////////////////////////////////PAINEL EAST////////////////////////////////////////////////////////
        painelEast = new JPanel();    //Inicializa o painel central
        painelEast.setLayout(null);
        painelEast.setPreferredSize(new Dimension(150, 0));

        //Criar elementos Painel EAST
        adicionar = new JButton("Adicionar");
        editarNome = new JButton("\u270E Nome");
        editarPreco = new JButton("\u270E Preço");
        editarDisponibilidade = new JButton("\u270E Disponibilidade");

        adicionar.addActionListener(this);  //adicionar o botão ao actionListener
        editarNome.addActionListener(this);    //adicionar o botão ao actionListener
        editarPreco.addActionListener(this);    //adicionar o botão ao actionListener
        editarDisponibilidade.addActionListener(this);    //adicionar o botão ao actionListener


        //Add ao painel
        painelEast.add(adicionar).setBounds(0, 125, 120, 35);
        painelEast.add(editarNome).setBounds(adicionar.getX(), adicionar.getY() + 50, 120, 35);
        painelEast.add(editarPreco).setBounds(adicionar.getX(),editarNome.getY() + 50, 120, 35);
        painelEast.add(editarDisponibilidade).setBounds(adicionar.getX(),editarPreco.getY() + 50, 120, 35);

        painelEast.setBackground(new Color(77, 24, 28));

        add(painelEast, BorderLayout.EAST);

        setVisible(true);
        carregarMusicasDoMusico();
        atualizarTabelaMusicas();
    }
    private void atualizarTabelaMusicas() {
        // Limpar os dados existentes na tabela
        tabelaDefault.setRowCount(0);

        // Adicionar as músicas do músico à tabela
        for (Musica musica : musicas) {
            String visibilidade="";
            if(musica.isVisibilidade()){
                 visibilidade = "Disponivel";
            }
            else{
                visibilidade = "Indisponivel";
            }
            Object[] rowData = {musica.getTitle(), musica.getGenre(), musica.getPreco(), visibilidade};
            tabelaDefault.addRow(rowData);
        }

        // Atualizar a exibição da tabela
        tabela.repaint();
    }
    public void carregarMusicasDoMusico() {
        // Limpar a lista de músicas
        musicas.clear();

        // Obter a lista de músicas do músico a partir do objeto RockStar
        Musico musico = (Musico) frameMusico.getRockStar().getUserAtivo();
        ArrayList<Musica> musicasDoMusico = musico.getMusicas();

        // Adicionar as músicas do músico à lista de músicas do MusicoMusicas
        musicas.addAll(musicasDoMusico);

        // Atualizar a exibição da tabela de músicas
        atualizarTabelaMusicas();
    }
    private ArrayList<Musica> ordenarMusicasPorNome() {
        ArrayList<Musica> musicasOrdenadas = new ArrayList<>(musicas);

        // Algoritmo de ordenação (bubble sort) para ordenar as músicas pelo título
        for (int i = 0; i < musicasOrdenadas.size() - 1; i++) {
            for (int j = 0; j < musicasOrdenadas.size() - i - 1; j++) {
                // Comparar os títulos das músicas e trocar se estiverem fora de ordem
                if (musicasOrdenadas.get(j).getTitle().compareToIgnoreCase(musicasOrdenadas.get(j + 1).getTitle()) > 0) {
                    Musica temp = musicasOrdenadas.get(j);
                    musicasOrdenadas.set(j, musicasOrdenadas.get(j + 1));
                    musicasOrdenadas.set(j + 1, temp);
                }
            }
        }
        return musicasOrdenadas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editarNome) {
            // Lógica para exibir detalhes da música selecionada
            int selectedRow = tabela.getSelectedRow();
            if (selectedRow != -1) {
                // Obter a música correta com base no índice selecionado na tabela ordenada
                int modelRow = tabela.convertRowIndexToModel(selectedRow);
                //converRowIndexToModel identifica o indice real da linha selecionada, independentemente de onde ela aparece.
                Musica musicaSelecionada = musicas.get(modelRow);

                new AlterarNome(frameMusico, frameMusico.getRockStar(), musicaSelecionada);
            } else {
                JOptionPane.showMessageDialog(MusicoMusicas.this, "Nenhuma música selecionada.");
            }
            carregarMusicasDoMusico();
            atualizarTabelaMusicas();
        } else if (e.getSource() == adicionar) {
            new AdicionarMusica(frameMusico,frameMusico.getRockStar());
            carregarMusicasDoMusico();
            atualizarTabelaMusicas();

        } else if (e.getSource() == editarPreco) {
            // Lógica para exibir detalhes da música selecionada
            int selectedRow = tabela.getSelectedRow();
            if (selectedRow != -1){
                // Obter a música correta com base no índice selecionado na tabela ordenada
                int modelRow = tabela.convertRowIndexToModel(selectedRow);
                Musica musicaSelecionada = musicas.get(modelRow);
                new AlterarPreco(frameMusico, frameMusico.getRockStar(), musicaSelecionada);
            }
            else JOptionPane.showMessageDialog(MusicoMusicas.this, "Nenhuma música selecionada.");
            carregarMusicasDoMusico();
            atualizarTabelaMusicas();

        } else if (e.getSource() == editarDisponibilidade) {
            // Lógica para exibir detalhes da música selecionada
            int selectedRow = tabela.getSelectedRow();
            if (selectedRow != -1){
                // Obter a música correta com base no índice selecionado na tabela ordenada
                int modelRow = tabela.convertRowIndexToModel(selectedRow);
                Musica musicaSelecionada = musicas.get(modelRow);
                new AlterarDisponibilidade(frameMusico, frameMusico.getRockStar(), musicaSelecionada);
            }
            else JOptionPane.showMessageDialog(MusicoMusicas.this, "Nenhuma música selecionada.");
            carregarMusicasDoMusico();
            atualizarTabelaMusicas();

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tabela.getTableHeader()) {
            int columnIndex = tabela.getColumnModel().getColumnIndexAtX(e.getX());
            if (columnIndex == 0) {
                musicas = ordenarMusicasPorNome();
                atualizarTabelaMusicas();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}



