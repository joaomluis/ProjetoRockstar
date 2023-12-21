package GUI.MenuCliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyPlaylists extends JPanel {

    private FrameCliente frameCliente;
    private JPanel topPanel;
    private JPanel eastPanel;
    private JTable playlistTable;
    private DefaultTableModel tableModel;
    private JButton seePlaylist;
    private JButton createPlaylist;
    private JButton deletePlaylist;
    private JLabel panelTitle;

    public MyPlaylists(FrameCliente frameCliente) {

        this.frameCliente = frameCliente;
        setLayout(new BorderLayout());
        setBackground(new Color(20, 64, 88));

        ///////////Painel Superior\\\\\\\\\\\\\\\\\\\\\\\\\\\
        topPanel = new JPanel();
        topPanel.setBackground(new Color(20, 64, 88));
        topPanel.setPreferredSize(new Dimension(0, 40));
        topPanel.setLayout(null);

        //Titulo do Painel
        panelTitle = new JLabel();
        panelTitle.setText("Minhas Playlists");
        panelTitle.setFont(new Font("Arial", Font.BOLD, 22));
        panelTitle.setForeground(new Color(198,107,61));
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

        playlistTable = new JTable(tableModel);
        playlistTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        playlistTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        playlistTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        // Impede a movimentação das colunas.
        playlistTable.getTableHeader().setReorderingAllowed(false);

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

        //botão para abrir playlist selecionada
        seePlaylist = new JButton();
        seePlaylist.setText("Ver");
        seePlaylist.setBounds(0, createPlaylist.getY() + 50, 120, 35);
        seePlaylist.setFocusable(false);

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

}
