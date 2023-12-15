package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GUI {


    private JLabel labelWelcomeText;
    private JFrame frame;
    private JPanel panel;
    private JButton logInButton;
    private JButton createAccButton;

    public GUI() {

        ImageIcon logoRockStar = new ImageIcon("logo_2.png");

        //Criação da frame inicial
        frame = new JFrame();
        frame.setTitle("RockStar.Inc");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(logoRockStar.getImage());

        //Texto da plataforma RockStar
        labelWelcomeText = new JLabel();
        labelWelcomeText.setText("RockStar.Inc");
        //labelWelcomeText.setHorizontalAlignment(JLabel.CENTER);
        //labelWelcomeText.setVerticalAlignment(JLabel.TOP);
        labelWelcomeText.setForeground(Color.BLACK);
        labelWelcomeText.setBorder(new LineBorder(Color.BLACK));
        labelWelcomeText.setFont(new Font("Arial", Font.BOLD, 30));
        labelWelcomeText.setBounds(150, 80, 200, 40);

        logInButton = new JButton();


        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(124, 98, 171));
        panel.add(labelWelcomeText);


        frame.setVisible(true);
        frame.add(panel);
        frame.revalidate();

    }

}
