package GUI.MenuMusico;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Painel1 extends JPanel implements ActionListener {
    private FrameMusic mainFrame;
    private JButton btnTeste;
    private JButton btnTeste2;

    public Painel1(FrameMusic mainFrame) {
        this.mainFrame = mainFrame;

        setBackground(Color.GREEN);
        setLayout(new FlowLayout());

        btnTeste = new JButton("Botao teste");
        btnTeste2 = new JButton("Botao teste 2");
        btnTeste.addActionListener(this);
        btnTeste2.addActionListener(this);

        add(btnTeste);
        add(btnTeste2);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}