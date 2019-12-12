package Application;

import Controller.CarController;
import Model.*;
import View.CarView;
import View.SpeedView;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Instance of this class
        CarView carframe = new CarView("Sim 1.0");
        SpeedView speedframe = new SpeedView();
        CarController cc = new CarController(carframe, speedframe, new MotorizedVehicleFactory());
        MotorizedVehicleFactory test = new MotorizedVehicleFactory();

        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        for (MotorizedVehicle car : cc.cars) {
            String s = "pics/" + car.getModelName() + ".jpg";
            System.out.println(s);
            try {
                carframe.drawPanel.carImages.add(ImageIO.read(CarView.class.getResourceAsStream(s)));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

            // Start the timer
            cc.timer.start();
    }
}
