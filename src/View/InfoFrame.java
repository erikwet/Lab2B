package View;

import javax.swing.*;
import java.awt.*;

public class InfoFrame extends JFrame {


    private static final int X = 800;
    private static final int Y = 200;

    private JPanel infoPanel = new JPanel();

    private JLabel carLabel1 = new JLabel("Volvo240");
    private JLabel speedLabel1 = new JLabel("CurrentSpeed: 100");

    private JLabel carLabel2 = new JLabel("Volvo240");
    private JLabel speedLabel2 = new JLabel("CurrentSpeed: 100");

    private JLabel carLabel3 = new JLabel("Volvo240");
    private JLabel speedLabel3 = new JLabel("CurrentSpeed: 100");

    private JLabel carLabel4 = new JLabel("Volvo240");
    private JLabel speedLabel4 = new JLabel("CurrentSpeed: 100");

    private JLabel carLabel5 = new JLabel("Volvo240");
    private JLabel speedLabel5 = new JLabel("CurrentSpeed: 100");

    private JLabel carLabel6 = new JLabel("Volvo240");
    private JLabel speedLabel6 = new JLabel("CurrentSpeed: 100");

    private JLabel carLabel7 = new JLabel("Volvo240");
    private JLabel speedLabel7 = new JLabel("CurrentSpeed: 100");

    private JLabel carLabel8 = new JLabel("Volvo240");
    private JLabel speedLabel8 = new JLabel("CurrentSpeed: 100");

    private JLabel carLabel9 = new JLabel("Volvo240");
    private JLabel speedLabel9 = new JLabel("CurrentSpeed: 100");

    private JLabel carLabel10 = new JLabel("Volvo240");
    private JLabel speedLabel10 = new JLabel("CurrentSpeed: 100");

    public InfoFrame() {
        initInfoPanel();
    }

    private void initInfoPanel(){
        this.setPreferredSize(new Dimension(X, Y));

        infoPanel.setLayout(new GridLayout(10, 2));

        infoPanel.add(carLabel1, 0);
        infoPanel.add(speedLabel1, 1);
        infoPanel.add(carLabel2, 2);
        infoPanel.add(speedLabel2, 3);
        infoPanel.add(carLabel3, 4);
        infoPanel.add(speedLabel3, 5);
        infoPanel.add(carLabel4, 6);
        infoPanel.add(speedLabel4, 7);
        infoPanel.add(carLabel5, 8);
        infoPanel.add(speedLabel5, 9);
        infoPanel.add(carLabel6, 10);
        infoPanel.add(speedLabel6, 11);

        infoPanel.setPreferredSize(new Dimension(X, Y));
        this.add(infoPanel);
        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2 - this.getWidth()/2, 800);

        // Make the frame visible
        this.setVisible(true);
    }
}
