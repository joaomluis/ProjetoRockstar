package GUI.MenuCliente;

import BackEnd.Musica;
import GUI.MenuCliente.PopUps.AddBalance;
import GUI.MenuCliente.PopUps.RateSong;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Store extends JPanel implements ActionListener {

    private FrameCliente frameCliente;
    private JPanel topPanel;
    private JPanel eastPanel;
    private JTable storeTable;
    private DefaultTableModel tableModel;
    private JButton buySong;
    private JButton addBalance;
    private JLabel panelTitle;
    private ArrayList<Musica> musicas;

    public Store (FrameCliente frameCliente) {

        this.frameCliente = frameCliente;
        setLayout(new BorderLayout());
        setBackground(new Color(20, 64, 88));

        this.musicas = new ArrayList<>();
        musicas.add(new Musica("Bohemian Rhapsody", "Queen", "Rock", 2.99));
        musicas.add(new Musica("Smells Like Teen Spirit", "Nirvana", "Grunge",1.89));
        musicas.add(new Musica("Imagine", "John Lennon", "Pop",1.89));
        musicas.add(new Musica("Hotel California", "Eagles", "Rock",1.99));
        musicas.add(new Musica("Shape of You", "Ed Sheeran", "Pop",2.59));


        ///////////Painel Superior\\\\\\\\\\\\\\\\\\\\\\\\\\\
        topPanel = new JPanel();
        topPanel.setBackground(new Color(20, 64, 88));
        topPanel.setPreferredSize(new Dimension(0, 40));
        topPanel.setLayout(null);

        //Titulo do Painel
        panelTitle = new JLabel();
        panelTitle.setText("Loja");
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
        tableModel.addColumn("Preço");

        //adiciona as musicas da array list à table, tem que ser trocado por um método mais tarde
        for (Musica musica : musicas) {
            Object[] row = {musica.getTitle(), musica.getArtist(), musica.getPreco()};
            tableModel.addRow(row);
        }

        storeTable = new JTable(tableModel);
        storeTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        storeTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        storeTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        // Impede a movimentação das colunas.
        storeTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(storeTable);

        // ADD scroll ao Panel
        scrollPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Define as margens
        scrollPane.setBackground(new Color(20, 64, 88));

        add(scrollPane, BorderLayout.CENTER);

        ///////// Painel Este \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        eastPanel = new JPanel();
        eastPanel.setBackground(new Color(20, 64, 88));
        eastPanel.setPreferredSize(new Dimension(150, 0));
        eastPanel.setLayout(null);

        //botão para comprar músicas
        buySong = new JButton();
        buySong.setText("Comprar");
        buySong.setBounds(0, 150, 120, 35);
        buySong.setFocusable(false);
        buySong.addActionListener(this);

        //botão para adicionar saldo
        addBalance = new JButton();
        addBalance.setText("Adicionar Saldo");
        addBalance.setBounds(0, buySong.getY() + 50, 120, 35);
        addBalance.setFocusable(false);
        addBalance.addActionListener(this);

        eastPanel.add(buySong);
        eastPanel.add(addBalance);

        add(eastPanel, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buySong) {
            int selectedRow = storeTable.getSelectedRow();
            if (selectedRow != -1) {
                // Obtenha os detalhes da música selecionada
                String title = (String) tableModel.getValueAt(selectedRow, 0);
                String artist = (String) tableModel.getValueAt(selectedRow, 1);
                Double preco = (double) tableModel.getValueAt(selectedRow, 2);

            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma música para comprar.");
            }
        } else if (e.getSource() == addBalance) {
            new AddBalance(frameCliente);
        }
    }
}
