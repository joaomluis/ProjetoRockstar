package GUI.MenuCliente;

import javax.swing.*;
import java.awt.*;

public class MenuInicial extends JPanel {

    private JPanel mainMenu;
    private JButton myMusic;
    private JButton myPlaylists;
    private JButton createPlaylist;
    private JButton purchaseHistory;
    private JButton logOut;
    private JButton store;
    private JLabel username;

    protected void mainPanel() {

        setLayout(null);
        setBackground(new Color(20,64,88));

        username = new JLabel();
        username.setText("RockStar.Inc");
        username.setForeground(new Color(198,107,61));
        username.setFont(new Font("Arial", Font.BOLD, 36));
        username.setBounds(138, 50, 223, 40);

        add(username);
    }
}
