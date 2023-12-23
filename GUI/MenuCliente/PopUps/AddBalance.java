package GUI.MenuCliente.PopUps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBalance extends JDialog implements ActionListener {

    private JPanel panelCenter;
    private JPanel panelSouth;
    private JLabel addBalanceLabel;
    private JTextField balanceField;
    private JButton okButton;
    private JButton cancelButton;

    public AddBalance(JFrame frame) {

        super(frame, "Adicionar Saldo", true);

        ////Especificações da janela\\\\\
        setSize(400, 150);
        setLayout(new BorderLayout());
        setResizable(false);

        ///////Painel central\\\\\\\\\
        panelCenter = new JPanel(null);

        addBalanceLabel = new JLabel();
        addBalanceLabel.setText("Carregar");
        addBalanceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        addBalanceLabel.setBounds(80,20,100,25);

        balanceField = new JTextField();
        balanceField.setBounds(addBalanceLabel.getX() + 120, addBalanceLabel.getY(), 80, 25);


        panelCenter.add(addBalanceLabel);
        panelCenter.add(balanceField);

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
        if (e.getSource() == cancelButton) {
            dispose();
        }
    }
}
