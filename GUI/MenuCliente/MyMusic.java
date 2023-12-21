package GUI.MenuCliente;

import BackEnd.Musica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

        tableModel.addColumn("Titulo");
        tableModel.addColumn("Artista");
        tableModel.addColumn("Género");

        musicTable = new JTable(tableModel);
        musicTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        musicTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        musicTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        // Impede a movimentação das colunas.
        musicTable.getTableHeader().setReorderingAllowed(false);

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

        //botão de remover músicas das adquiridas
        removeMusic = new JButton();
        removeMusic.setText("Remover");
        removeMusic.setBounds(0, rateMusic.getY() + 50, 120, 35);
        removeMusic.setFocusable(false);

        eastPanel.add(rateMusic);
        eastPanel.add(removeMusic);

        add(eastPanel, BorderLayout.EAST);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
