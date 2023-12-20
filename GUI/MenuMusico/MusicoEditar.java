package GUI.MenuMusico;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MusicoEditar extends JPanel implements ActionListener {
    private JButton alterarNome;
    private JButton alterarPreco;
    private FrameMusic frameMusic;
    private JButton botaoPesquisa;
    private JPanel painelSuperior;
    private JPanel painelCentral;
    private JButton alterarDisponibilidade;
    private JTextField pesquisa;

    public MusicoEditar(FrameMusic frameMusic) {
        this.frameMusic = frameMusic;
        setLayout(new BorderLayout());
        setBackground(new Color(124, 98, 171));


//        ////////////////////////////////////////PAINEL CENTRAL////////////////////////////////////////////////////////
        painelCentral = new JPanel();    //Inicializa o painel central
        painelCentral.setLayout(null);

        //Criar elementos Painel Central
        alterarPreco = new JButton("Alterar preço");
        alterarNome = new JButton("Alterar nome");
        alterarDisponibilidade = new JButton("Alterar disponibilidade");
        //Add elementos ao Painel Central
        painelCentral.add(alterarPreco).setBounds(250,100,300,40);
        alterarPreco.addActionListener(this);
        painelCentral.add(alterarNome).setBounds(alterarPreco.getX(), alterarPreco.getY()+ alterarPreco.getHeight()+10,300,40);
        alterarNome.addActionListener(this);
        painelCentral.add(alterarDisponibilidade).setBounds(alterarNome.getX(), alterarNome.getY()+ alterarNome.getHeight()+10,300,40);
        alterarDisponibilidade.addActionListener(this);

        painelCentral.setBackground(new Color(124, 98, 171));

        add(painelCentral,BorderLayout.CENTER);
//
//        ////////////////////////////////////////PAINEL SUPERIOR////////////////////////////////////////////////////////
        painelSuperior = new JPanel(); // Inicializa o painel superior
        painelSuperior.setBackground(new Color(124, 98, 171));
        painelSuperior.setPreferredSize(new Dimension(0, 40)); //Altura do painel Superior
        painelSuperior.setLayout(null);
        //Criar elementos Painel superior
        JLabel titulo = new JLabel("Editar Musica");  //Subsituir o Nome do usuario
        //Add elementos ao Painel superior
        painelSuperior.add(titulo).setBounds(380,0,120,20);

//        ////////////////////////////////////////CONTAINER////////////////////////////////////////////////////////
        Container contentPane = frameMusic.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(new Color(124, 98, 171));


        add(painelCentral, BorderLayout.CENTER);
        add(painelSuperior, BorderLayout.NORTH);

        //instrução da localização no layout
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == alterarPreco) {
            JOptionPane.showMessageDialog(MusicoEditar.this, "Botão 'Alterar Preço' pressionado.");
        }
        else if (e.getSource() == alterarNome) {
            JOptionPane.showMessageDialog(MusicoEditar.this, "Botão 'Alterar Nome' pressionado.");
        }
        else if (e.getSource() == alterarDisponibilidade) {
            JOptionPane.showMessageDialog(MusicoEditar.this, "Botão 'Alterar disponibilidade' pressionado.");

        }
    }


}



