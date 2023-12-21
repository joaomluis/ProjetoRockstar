package GUI.MenuMusico;

import GUI.MenuMusico.PopUps.CriarAlbum;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MusicoMeusAlbuns extends JPanel implements ActionListener {
    private JPanel painelEast;
    private JScrollPane scrollPane;
    private JLabel titulo;
    private JPanel painelSuperior;
    private DefaultTableModel tabelaDefault;
    private FrameMusico frameMusico;
    private JTable tabela;
    private JButton ver;
    private JButton criar;
    private ArrayList<String> albuns;

    public MusicoMeusAlbuns(FrameMusico frameMusico) {
        this.frameMusico = frameMusico;
        setLayout(new BorderLayout());
        this.albuns = new ArrayList<>();

//        ////////////////////////////////////////PAINEL SUPERIOR////////////////////////////////////////////////////////
        painelSuperior = new JPanel(); // Inicializa o painel superior
        painelSuperior.setBackground(new Color(77, 24, 28));
        painelSuperior.setPreferredSize(new Dimension(0, 40)); //Altura do painel Superior
        painelSuperior.setLayout(null);

        //Criar elementos Painel superior
        titulo = new JLabel("Meus Albuns");
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
        tabelaDefault.addColumn("Nome");
        tabelaDefault.addColumn("Gênero");
        tabelaDefault.addColumn("Produtor");

//        // Adiciona as músicas ao modelo de tabela
//        for (Album album : albuns) {
//            Object[] musicaObjeto = {album.getNome(), album.getGenero(), album.getProdutor()};
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
        painelEast.setPreferredSize(new Dimension(150, 0));

        //Criar elementos Painel EAST
        ver = new JButton("Ver");
        ver.addActionListener(this);    //adicionar o botão ao actionListener
        criar = new JButton("Criar");
        criar.addActionListener(this);  //adicionar o botão ao actionListener
        //Add elementos ao Painel Central
        painelEast.add(ver).setBounds(0,125,120,35);
        painelEast.add(criar).setBounds(ver.getX(), ver.getY() + 50,120,35);

        painelEast.setBackground(new Color(77, 24, 28));

        add(painelSuperior, BorderLayout.NORTH);
        add(painelEast, BorderLayout.EAST);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ver){
            // Lógica para exibir detalhes da música selecionada
            int selectedRow = tabela.getSelectedRow();
            if (selectedRow != -1) {
                String nome = (String) tabela.getValueAt(selectedRow, 0);
                String genero = (String) tabela.getValueAt(selectedRow, 1);
                String produtor = (String) tabela.getValueAt(selectedRow, 2);

                frameMusico.showMusicoAlbum();
            }
            else {
                JOptionPane.showMessageDialog(MusicoMeusAlbuns.this, "Nenhum album selecionado.");
            }
        }
        else if(e.getSource() == criar){
            new CriarAlbum(frameMusico);
        }
    }
}



