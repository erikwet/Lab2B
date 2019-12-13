package View;

import Controller.IObserver;
import Model.MotorizedVehicle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InfoFrame extends JFrame implements IObserver {

    ArrayList<JLabel> speedLabels = new ArrayList<>();
    ArrayList<JLabel> carLabels = new ArrayList<>();

    private static final int X = 800;
    private static final int Y = 200;

    private JPanel infoPanel = new JPanel();

    private JLabel carLabel1 = new JLabel();
    private JLabel speedLabel1 = new JLabel();

    private JLabel carLabel2 = new JLabel();
    private JLabel speedLabel2 = new JLabel();

    private JLabel carLabel3 = new JLabel();
    private JLabel speedLabel3 = new JLabel();

    private JLabel carLabel4 = new JLabel();
    private JLabel speedLabel4 = new JLabel();

    private JLabel carLabel5 = new JLabel();
    private JLabel speedLabel5 = new JLabel();

    private JLabel carLabel6 = new JLabel();
    private JLabel speedLabel6 = new JLabel();

    private JLabel carLabel7 = new JLabel();
    private JLabel speedLabel7 = new JLabel();

    private JLabel carLabel8 = new JLabel();
    private JLabel speedLabel8 = new JLabel();

    private JLabel carLabel9 = new JLabel();
    private JLabel speedLabel9 = new JLabel();

    private JLabel carLabel10 = new JLabel();
    private JLabel speedLabel10 = new JLabel();



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
        infoPanel.add(carLabel7, 12);
        infoPanel.add(speedLabel7, 13);
        infoPanel.add(carLabel8,14);
        infoPanel.add(speedLabel8,15);
        infoPanel.add(carLabel9, 16);
        infoPanel.add(speedLabel9,17);
        infoPanel.add(carLabel10,18);
        infoPanel.add(speedLabel10,19);

        carLabels.add(carLabel1);
        speedLabels.add(speedLabel1);
        carLabels.add(carLabel2);
        speedLabels.add(speedLabel2);
        carLabels.add(carLabel3);
        speedLabels.add(speedLabel3);
        carLabels.add(carLabel4);
        speedLabels.add(speedLabel4);
        carLabels.add(carLabel5);
        speedLabels.add(speedLabel5);
        carLabels.add(carLabel6);
        speedLabels.add(speedLabel6);
        carLabels.add(carLabel7);
        speedLabels.add(speedLabel7);
        carLabels.add(carLabel8);
        speedLabels.add(speedLabel8);
        carLabels.add(carLabel9);
        speedLabels.add(speedLabel9);
        carLabels.add(carLabel10);
        speedLabels.add(speedLabel10);

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

    @Override
    public void actOnSpeedChange(ArrayList<MotorizedVehicle> cars) {
        for(int i = 0; i < cars.size(); i++) {
            speedLabels.get(i).setText("Speed: " + cars.get(i).getCurrentSpeed());
        }
    }

    @Override
    public void actOnListSizeChange(ArrayList<MotorizedVehicle> cars) {
        for(int i = 0; i < cars.size(); i++) {
            carLabels.get(i).setText("Model: " + cars.get(i).getModelName());
        }
        for(int i = cars.size(); i < 10; i++) {
            carLabels.get(i).setText("");
            speedLabels.get(i).setText("");
        }
    }
}
