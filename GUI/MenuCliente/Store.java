package GUI.MenuCliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Store extends JPanel {

    private FrameCliente frameCliente;
    private JPanel topPanel;
    private JPanel eastPanel;
    private JTable storeTable;
    private DefaultTableModel tableModel;
    private JButton buySong;
    private JButton addBalance;
    private JLabel panelTitle;

    public Store (FrameCliente frameCliente) {

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

        //botão para adicionar saldo
        addBalance = new JButton();
        addBalance.setText("Adicionar Saldo");
        addBalance.setBounds(0, buySong.getY() + 50, 120, 35);
        addBalance.setFocusable(false);

        eastPanel.add(buySong);
        eastPanel.add(addBalance);

        add(eastPanel, BorderLayout.EAST);
    }
}
