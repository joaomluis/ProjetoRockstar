package GUI.MenuCliente;

import BackEnd.Musica;
import GUI.MenuCliente.PopUps.MakePlaylist;
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

public class MyPlaylists extends JPanel implements ActionListener {

    private FrameCliente frameCliente;
    private JPanel topPanel;
    private JPanel eastPanel;
    private JTable playlistTable;
    private DefaultTableModel tableModel;
    private JButton seePlaylist;
    private JButton createPlaylist;
    private JButton deletePlaylist;
    private JLabel panelTitle;
    private ArrayList<Musica> musicas; //alterar para playlists

    public MyPlaylists(FrameCliente frameCliente) {

        this.frameCliente = frameCliente;
        setLayout(new BorderLayout());
        setBackground(new Color(20, 64, 88));

        ///SO PARA TESTAR
        this.musicas = new ArrayList<>();
        musicas.add(new Musica("Bohemian Rhapsody", "Queen", "Rock"));
        musicas.add(new Musica("Smells Like Teen Spirit", "Nirvana", "Grunge"));
        musicas.add(new Musica("Imagine", "John Lennon", "Pop"));
        musicas.add(new Musica("Hotel California", "Eagles", "Rock"));
        musicas.add(new Musica("Shape of You", "Ed Sheeran", "Pop"));

        ///////////Painel Superior\\\\\\\\\\\\\\\\\\\\\\\\\\\
        topPanel = new JPanel();
        topPanel.setBackground(new Color(20, 64, 88));
        topPanel.setPreferredSize(new Dimension(0, 40));
        topPanel.setLayout(null);

        //Titulo do Painel
        panelTitle = new JLabel();
        panelTitle.setText("Minhas Playlists");
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

        tableModel.addColumn("Nome");
        tableModel.addColumn("Artista");
        tableModel.addColumn("Género");

        //adiciona as musicas da array list à table, tem que ser trocado por um método mais tarde
        for (Musica musica : musicas) {
            Object[] row = {musica.getTitle(), musica.getArtist(), musica.getGenre()};
            tableModel.addRow(row);
        }

        playlistTable = new JTable(tableModel);
        playlistTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        playlistTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        playlistTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        // Impede a movimentação das colunas.
        playlistTable.getTableHeader().setReorderingAllowed(false);

        // Adicionando TableRowSorter à JTable - ordena a tabela
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        playlistTable.setRowSorter(sorter);

        playlistTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Para evitar eventos duplicados
                    boolean isRowSelected = playlistTable.getSelectedRow() != -1;
                    deletePlaylist.setEnabled(isRowSelected); // Habilita ou desabilita o botão com base na seleção
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(playlistTable);

        // ADD scroll ao Panel
        scrollPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Define as margens
        scrollPane.setBackground(new Color(20, 64, 88));

        add(scrollPane, BorderLayout.CENTER);

        ///////// Painel Este \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        eastPanel = new JPanel();
        eastPanel.setBackground(new Color(20, 64, 88));
        eastPanel.setPreferredSize(new Dimension(150, 0));
        eastPanel.setLayout(null);

        //botão para criar nova playlist vazia
        createPlaylist = new JButton();
        createPlaylist.setText("Criar Playlist");
        createPlaylist.setBounds(0, 150, 120, 35);
        createPlaylist.setFocusable(false);
        createPlaylist.addActionListener(this);

        //botão para abrir playlist selecionada
        seePlaylist = new JButton();
        seePlaylist.setText("Ver");
        seePlaylist.setBounds(0, createPlaylist.getY() + 50, 120, 35);
        seePlaylist.setFocusable(false);
        seePlaylist.addActionListener(this);

        //botão para apagar playlist
        deletePlaylist = new JButton();
        deletePlaylist.setText("Remover");
        deletePlaylist.setBounds(0, seePlaylist.getY() + 50, 120, 35);
        deletePlaylist.setFocusable(false);

        eastPanel.add(createPlaylist);
        eastPanel.add(seePlaylist);
        eastPanel.add(deletePlaylist);

        add(eastPanel, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == seePlaylist) {
            int selectedRow = playlistTable.getSelectedRow();
            if (selectedRow != -1) {
                // Obtenha os detalhes da música selecionada
                String title = (String) tableModel.getValueAt(selectedRow, 0);
                String artist = (String) tableModel.getValueAt(selectedRow, 1);
                String genre = (String) tableModel.getValueAt(selectedRow, 2);
                frameCliente.showCurrentPlaylist();
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma playlist para abrir.");
            }
        } else if (e.getSource() == createPlaylist) {
            new MakePlaylist(frameCliente);
        }
    }
}
