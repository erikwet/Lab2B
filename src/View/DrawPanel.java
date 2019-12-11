package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    public ArrayList<BufferedImage> carImages = new ArrayList<>();
    private ArrayList<Point> carPoints = new ArrayList<>();

    // TODO: Make this genereal for all cars
    public void moveit(int x, int y, int i){
        Point p = new Point();
        p.x = x;
        p.y = y;
        carPoints.add(i, p);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.DARK_GRAY);
        // Print an error message in case file is not found with a try/catch block

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < carImages.size(); i++) {
            g.drawImage(carImages.get(i), carPoints.get(i).x, carPoints.get(i).y, null);
        }
         // see javadoc for more info on the parameters
    }
}
