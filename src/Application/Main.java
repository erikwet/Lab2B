package Application;

import Controller.CarController;
import Model.*;
import View.CarView;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Instance of this class
        CarView frame = new CarView("Sim 1.0");
        CarController cc = new CarController(frame);
        MotorizedVehicleFactory test = new MotorizedVehicleFactory();

        cc.cars.add(test.createMotorizedVehicle());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        for (MotorizedVehicle car : cc.cars) {
            String s = "pics/" + car.getModelName() + ".jpg";
            System.out.println(s);
            try {
                frame.drawPanel.carImages.add(ImageIO.read(CarView.class.getResourceAsStream(s)));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

            // Start the timer
            cc.timer.start();
    }
}
