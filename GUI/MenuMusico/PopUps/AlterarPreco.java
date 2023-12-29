package GUI.MenuMusico.PopUps;

import BackEnd.Musica;
import BackEnd.RockStar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarPreco extends JDialog implements ActionListener{
    private JPanel panelCenter;
    private JPanel panelSouth;
    private JLabel preco;
    private JTextField textField;
    private JButton okButton;
    private JButton cancelButton;
    private int width = 300;
    private int height = 100;
    private RockStar rockStar;
    private Musica musica;
    public AlterarPreco(Frame parent, RockStar rockStar, Musica musica) {
        super(parent, "Alterar Preço", true);
        this.rockStar = rockStar;
        this.musica = musica;
//SETTINGS DA JANELA////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        setSize(width,height);
        setLayout(new BorderLayout());
        setResizable(false);
//CRIAR BOTÕES//////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        textField = new JTextField();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancelar");
        preco = new JLabel("Novo preço:");

//(PANEL CENTER) CAMPOS LABEL/DROPDOWN/TEXT/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        panelCenter = new JPanel(null); //Cria painel central

        panelCenter.add(preco).setBounds(20,10,90,25);
        panelCenter.add(textField).setBounds(preco.getX()+ preco.getWidth(), preco.getY(),170,25);
//(PANEL SOUTH) BOTÕES OK E CANCELAR////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER)); //Cria painel sul

        panelSouth.add(okButton);
        panelSouth.add(cancelButton);
        //Adicionar ao listener.
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
//(PAINEL PRINCIPAL) ADD AO PAINEL//////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        add(panelCenter, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);
        setLocationRelativeTo(parent); // Centraliza o diálogo em relação à frame principal. (Para ñ aparecer ao canto)
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelButton){
            dispose();// Fecha o pop-up.
        }
        else if(e.getSource() == okButton){
         String escolhaPreco = textField.getText();
        Double novoPreco = Double.parseDouble(escolhaPreco);
            if (musica != null) {
                boolean alteracaoSucesso = musica.alterarPreco(novoPreco,rockStar.getUserAtivoMusico());

                if (alteracaoSucesso) {
                    // O preço da música foi atualizado com sucesso
                    System.out.println("O nome da música foi atualizado para: " + escolhaPreco);
                } else {
                    // A alteração do nome falhou
                    System.out.println("Falha ao atualizar o preço da música.");
                }
            }
            //
            dispose(); // Fecha o pop-up.
        }
    }
}