package GUI.MenuCliente;

import BackEnd.Musica;
import GUI.MenuCliente.PopUps.AddToPlaylist;
import GUI.MenuCliente.PopUps.RateSong;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyMusic extends JPanel implements ActionListener {

    private FrameCliente frameCliente;
    private JPanel topPanel;
    private JPanel eastPanel;
    private JTable musicTable;
    private DefaultTableModel tableModel;
    private JButton removeMusic;
    private JButton rateMusic;
    private JButton addToPlaylist;
    private JLabel panelTitle;
    private ArrayList<Musica> musicas;

    public MyMusic(FrameCliente frameCliente) {

        this.frameCliente = frameCliente;
        setLayout(new BorderLayout());
        setBackground(new Color(20, 64, 88));

        this.musicas = new ArrayList<>();


        ///////////Painel Superior\\\\\\\\\\\\\\\\\\\\\\\\\\\
        topPanel = new JPanel();
        topPanel.setBackground(new Color(20, 64, 88));
        topPanel.setPreferredSize(new Dimension(0, 40));
        topPanel.setLayout(null);

        //Titulo do Painel
        panelTitle = new JLabel();
        panelTitle.setText("Minhas Músicas");
        panelTitle.setFont(new Font("Arial", Font.BOLD, 22));
        panelTitle.setForeground(new Color(198, 107, 61));
        panelTitle.setBounds(250, 5, 250, 30);

        topPanel.add(panelTitle);

        add(topPanel, BorderLayout.NORTH);

        ///////////Painel Central\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableModel.addColumn("Titulo");
        tableModel.addColumn("Artista");
        tableModel.addColumn("Género");

        //adiciona as musicas da array list à table, tem que ser trocado por um método mais tarde
        for (Musica musica : musicas) {
            Object[] row = {musica.getTitle(), musica.getArtist(), musica.getGenre()};
            tableModel.addRow(row);
        }


        musicTable = new JTable(tableModel);
        musicTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        musicTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        musicTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        // Impede a movimentação das colunas.
        musicTable.getTableHeader().setReorderingAllowed(false);

        // Adicionando TableRowSorter à JTable - ordena a tabela
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        musicTable.setRowSorter(sorter);

        musicTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Para evitar eventos duplicados
                    boolean isRowSelected = musicTable.getSelectedRow() != -1;
                    rateMusic.setEnabled(isRowSelected); // Habilita ou desabilita o botão com base na seleção
                }
            }
        });


        JScrollPane scrollPane = new JScrollPane(musicTable);

        // ADD scroll ao Panel
        scrollPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Define as margens
        scrollPane.setBackground(new Color(20, 64, 88));

        add(scrollPane, BorderLayout.CENTER);

        ///////// Painel Este \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        eastPanel = new JPanel();
        eastPanel.setBackground(new Color(20, 64, 88));
        eastPanel.setPreferredSize(new Dimension(150, 0));
        eastPanel.setLayout(null);

        //botão de avaliar músicas
        rateMusic = new JButton();
        rateMusic.setText("Avaliar Música");
        rateMusic.setBounds(0, 150, 120, 35);
        rateMusic.setFocusable(false);
        rateMusic.addActionListener(this);

        //botão de remover músicas das adquiridas
        removeMusic = new JButton();
        removeMusic.setText("Remover");
        removeMusic.setBounds(0, rateMusic.getY() + 50, 120, 35);
        removeMusic.setFocusable(false);
        removeMusic.addActionListener(this);

        //botão para adicionar música a uma playlist;
        addToPlaylist = new JButton();
        addToPlaylist.setText("Adicionar");
        addToPlaylist.setBounds(0, removeMusic.getY() + 50, 120, 35);
        addToPlaylist.setFocusable(false);
        addToPlaylist.addActionListener(this);

        eastPanel.add(rateMusic);
        eastPanel.add(removeMusic);
        eastPanel.add(addToPlaylist);

        add(eastPanel, BorderLayout.EAST);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rateMusic) {
            int selectedRow = musicTable.getSelectedRow();
            if (selectedRow != -1) {
                // Obtenha os detalhes da música selecionada
                String title = (String) tableModel.getValueAt(selectedRow, 0);
                String artist = (String) tableModel.getValueAt(selectedRow, 1);
                String genre = (String) tableModel.getValueAt(selectedRow, 2);
                new RateSong(frameCliente);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma música para avaliar.");
            }
        } else if (e.getSource() == removeMusic) {
            int selectedRow = musicTable.getSelectedRow();
            if (selectedRow != -1) {
                // Remove da tabela
                tableModel.removeRow(selectedRow);
                // Remove da lista de músicas
                musicas.remove(selectedRow);
                rateMusic.setEnabled(true); // faz com que o botão de avaliar não fique disabled após remover uma música
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma música para remover.");
            }
        } else if (e.getSource() == addToPlaylist) {
            int selectedRow = musicTable.getSelectedRow();
            if (selectedRow != -1) {
                // Obtenha os detalhes da música selecionada
                String title = (String) tableModel.getValueAt(selectedRow, 0);
                String artist = (String) tableModel.getValueAt(selectedRow, 1);
                String genre = (String) tableModel.getValueAt(selectedRow, 2);
                new AddToPlaylist(frameCliente);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma música para adicionar.");
            }
        }
    }
}
