package View;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame {

    private static final int X = 800;
    private static final int Y = 800;

    public DrawPanel drawPanel = new DrawPanel(X, Y - 240);

    // The controller member

    private JPanel controlPanel = new JPanel();
    private JPanel gasPanel = new JPanel();
    private JPanel specialControlPanel = new JPanel();
    private JSpinner gasSpinner = new JSpinner();
    private int gasAmount = 0;
    private JLabel gasLabel = new JLabel("Amount of gas");

    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab: Turbo on");
    private JButton turboOffButton = new JButton("Saab: Turbo off");
    private JButton liftBedButton = new JButton("Scania: Lift Flatbed");
    private JButton lowerBedButton = new JButton("Scania: Lower Flatbed");

    private JButton addCarButton = new JButton("Add car");
    private JButton removeCarButton = new JButton("Remove car");
    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String framename) {
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        specialControlPanel.setLayout(new GridLayout(2, 2));

        specialControlPanel.add(startButton, 0);
        specialControlPanel.add(stopButton, 1);
        specialControlPanel.add(addCarButton, 2);
        specialControlPanel.add(removeCarButton, 3);
        specialControlPanel.setPreferredSize(new Dimension((X / 4) + 98, 200));
        this.add(specialControlPanel);
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        addCarButton.setBackground(Color.green);
        addCarButton.setForeground(Color.black);
        removeCarButton.setBackground(Color.black);
        removeCarButton.setForeground(Color.white);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getWidth()/2, 0);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int getGasAmount() {
        return gasAmount;
    }

    public JButton getGasButton() {
        return gasButton;
    }

    public JButton getBrakeButton() {
        return brakeButton;
    }

    public JButton getTurboOnButton() {
        return turboOnButton;
    }

    public JButton getTurboOffButton() {
        return turboOffButton;
    }

    public JButton getLiftBedButton() {
        return liftBedButton;
    }

    public JButton getLowerBedButton() {
        return lowerBedButton;
    }

    public JButton getAddCarButton() {
        return addCarButton;
    }

    public JButton getRemoveCarButton() {
        return removeCarButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }
}