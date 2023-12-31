package GUI.MenuMusico.PopUps;

import BackEnd.Musica;
import BackEnd.Musico;
import BackEnd.RockStar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarMusica extends JDialog implements ActionListener{
    private JComboBox<Object> albumDropdown;
    private JLabel album;
    private JLabel preco;
    private JTextField precoText;
    private JPanel panelCenter;
    private JPanel panelSouth;
    private JLabel genero;
    private JLabel nome;
    private JComboBox<String> dropdown;
    private JTextField nomeText;
    private JButton okButton;
    private JButton cancelButton;
    private int width = 400;
    private int height = 200;
    private RockStar rockstar;


    public AdicionarMusica(Frame parent, RockStar rockStar) {
        super(parent, "Adicionar Música", true);
        this.rockstar = rockStar;
//SETTINGS DA JANELA////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        setSize(width,height);
        setLayout(new BorderLayout());
        setResizable(false);
//CRIAR BOTÕES//////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        dropdown = new JComboBox<>(rockStar.getGenerosMusicais());
        nomeText = new JTextField();
        precoText = new JTextField();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancelar");
        nome = new JLabel("Nome:");
        genero = new JLabel("Genero:");
        preco = new JLabel("Preço:");
        album = new JLabel("Album:");
        albumDropdown = new JComboBox<>(rockStar.albunsDoMusico(rockStar.getUserAtivoMusico()));//vetor com os albuns.

//(PANEL CENTER) CAMPOS LABEL/DROPDOWN/TEXT/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        panelCenter = new JPanel(null); //Cria painel central

        panelCenter.add(nome).setBounds(80,10,50,25);
        panelCenter.add(nomeText).setBounds(nome.getX()+nome.getWidth()+5,nome.getY(),190,25);
        panelCenter.add(genero).setBounds(nome.getX(), nomeText.getY()+ nomeText.getHeight()+5,50,25);
        panelCenter.add(dropdown).setBounds(nomeText.getX(),nome.getY()+nome.getHeight()+5,190,25);
        panelCenter.add(preco).setBounds(nome.getX(), genero.getY()+ genero.getHeight()+5,50,25);
        panelCenter.add(precoText).setBounds(nomeText.getX(), genero.getY()+ genero.getHeight()+5,190,25);
        panelCenter.add(album).setBounds(nome.getX(),preco.getY()+preco.getHeight()+5,190,25);
        panelCenter.add(albumDropdown).setBounds(nomeText.getX(),preco.getY()+preco.getHeight()+5,190,25);

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
         String escolhaGenero = (String) dropdown.getSelectedItem();
         String escolhaNome = nomeText.getText();
         String escolhaPreco = precoText.getText();
         if(escolhaPreco.isEmpty()){
             JOptionPane.showMessageDialog(null, "A sua música tem de ter um preço. Por exemplo: 0.00");
         }else {

             double preco = Double.parseDouble(escolhaPreco);
             Musico musico = (Musico) rockstar.getUserAtivo();
             Musica novaMusica = new Musica(escolhaNome, musico, escolhaGenero, preco);

             if (!rockstar.addMusica(novaMusica)) {
                 JOptionPane.showMessageDialog(null, "Já existe uma música na sua lista com esse nome. Por favor, escolha outro nome para a sua música.");
             } else {
                 musico.addMusica(novaMusica);
                 rockstar.addMusica(novaMusica);
                 dispose(); // Fecha o pop-up.
             }
         }
        }
    }
}