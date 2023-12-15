package GUI;

import javax.swing.*;

public class LogIn{

        private JLabel label;
        private JFrame frame;
        private JPanel panel;

        public LogIn() {


            frame = new JFrame();

            frame.setTitle("RockStar.Inc");
            frame.setSize(600, 500);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

}
