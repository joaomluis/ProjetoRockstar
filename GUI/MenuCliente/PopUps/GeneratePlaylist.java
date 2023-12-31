package GUI.MenuCliente.PopUps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratePlaylist extends JDialog implements ActionListener {

    private JPanel panelCenter;
    private JPanel panelSouth;
    private JLabel playlistName;
    private JLabel playlistGenre;
    private JLabel playlistSize;
    private JTextField nameField;
    private JTextField sizeField;
    private JComboBox<String> dropdown;
    private JButton okButton;
    private JButton cancelButton;

    public GeneratePlaylist(JFrame frame) {
        super(frame, "Gerar Playlist", true);

        ////Especificações da janela\\\\\
        setSize(400, 220);
        setLayout(new BorderLayout());
        setResizable(false);

        ///////Painel central\\\\\\\\\
        panelCenter = new JPanel(null);

        playlistName = new JLabel();
        playlistName.setText("Nome");
        playlistName.setFont(new Font("Arial", Font.BOLD, 18));
        playlistName.setBounds(100,20,65,25);

        nameField = new JTextField();
        nameField.setBounds(playlistName.getX() + 80, playlistName.getY(), 130, 25);

        playlistSize = new JLabel();
        playlistSize.setText("Tamanho");
        playlistSize.setFont(new Font("Arial", Font.BOLD, 18));
        playlistSize.setBounds(playlistName.getX(), playlistName.getY() + 35, 90, 25);

        sizeField = new JTextField();
        sizeField.setBounds(playlistSize.getX() + 90, playlistSize.getY(), 120, 25);

        playlistGenre = new JLabel();
        playlistGenre.setText("Género");
        playlistGenre.setFont(new Font("Arial", Font.BOLD, 18));
        playlistGenre.setBounds(playlistSize.getX(), playlistSize.getY() + 35, 90, 25);

        dropdown = new JComboBox<>();
        dropdown.addItem("Rock");
        dropdown.addItem("Pop");
        dropdown.addItem("Folk");
        dropdown.addItem("Indie");
        dropdown.setBounds(playlistGenre.getX() + 90, playlistGenre.getY(), 120, 25);

        panelCenter.add(playlistName);
        panelCenter.add(nameField);
        panelCenter.add(playlistSize);
        panelCenter.add(sizeField);
        panelCenter.add(playlistGenre);
        panelCenter.add(dropdown);

        //////Painel sul\\\\\\\\\\\
        panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));

        okButton = new JButton();
        okButton.setText("Ok");
        okButton.setFocusable(false);
        okButton.addActionListener(this);

        cancelButton = new JButton();
        cancelButton.setText("Cancelar");
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);

        panelSouth.add(okButton);
        panelSouth.add(cancelButton);

        /////////Painel Principal\\\\\\\\\\\\\

        add(panelCenter, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);

        setLocationRelativeTo(frame);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelButton){
            dispose();
        }
    }
}
