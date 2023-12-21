package GUI.MenuMusico;

import BackEnd.Musica;
import GUI.MenuMusico.PopUps.AdicionarMusica;
import GUI.MenuMusico.PopUps.AlterarDisponibilidade;
import GUI.MenuMusico.PopUps.AlterarNome;
import GUI.MenuMusico.PopUps.AlterarPreco;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MusicoMusicas extends JPanel implements ActionListener {
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
    private int sortByNameOrder = 1;


    public MusicoMusicas(FrameMusico frameMusico) {

        this.frameMusico = frameMusico;
        setLayout(new BorderLayout());
        setBackground(new Color(124, 98, 171));

        this.musicas = new ArrayList<>(); //ler o ficheiro

//        ////////////////////////////////////////PAINEL SUPERIOR////////////////////////////////////////////////////////
        painelSuperior = new JPanel(); // Inicializa o painel superior
        painelSuperior.setBackground(new Color(124, 98, 171));
        painelSuperior.setPreferredSize(new Dimension(0, 40)); //Altura do painel Superior
        painelSuperior.setLayout(null);

        //Criar elementos Painel superior
        titulo = new JLabel("Minhas Músicas");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(new Color(198,107,61));
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
        tabelaDefault.addColumn("Artista");
        tabelaDefault.addColumn("Género");

        tabela = new JTable(tabelaDefault);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(200);
        // Impede a movimentação das colunas.
        tabela.getTableHeader().setReorderingAllowed(false);

        scrollPane = new JScrollPane(tabela);

        // ADD scroll ao Panel
        scrollPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Define as margens
        scrollPane.setBackground(new Color(124, 98, 171));
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

        painelEast.setBackground(new Color(124, 98, 171));

        add(painelEast, BorderLayout.EAST);

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
        if (e.getSource() == editarNome) {
            // Lógica para exibir detalhes da música selecionada
            int selectedRow = tabela.getSelectedRow();
            if (selectedRow == -1) new AlterarNome(frameMusico); //alterar para (selectedRow != -1) para funcionar corretamente
            else JOptionPane.showMessageDialog(MusicoMusicas.this, "Nenhuma música selecionada.");

        } else if (e.getSource() == adicionar) {
            new AdicionarMusica(frameMusico);

        } else if (e.getSource() == editarPreco) {
            // Lógica para exibir detalhes da música selecionada
            int selectedRow = tabela.getSelectedRow();
            if (selectedRow == -1) new AlterarPreco(frameMusico);
            else JOptionPane.showMessageDialog(MusicoMusicas.this, "Nenhuma música selecionada.");

        } else if (e.getSource() == editarDisponibilidade) {
            // Lógica para exibir detalhes da música selecionada
            int selectedRow = tabela.getSelectedRow();
            if (selectedRow == -1) new AlterarDisponibilidade(frameMusico);
            else JOptionPane.showMessageDialog(MusicoMusicas.this, "Nenhuma música selecionada.");
        }
    }
}



