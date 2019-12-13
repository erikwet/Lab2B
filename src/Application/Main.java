package Application;
import Controller.CarController;
import Model.*;
import View.CarView;
import View.InfoFrame;

public class Main {

    public static void main(String[] args) {
        // Instance of this class
        CarView carFrame = new CarView("Sim 1.0");
        InfoFrame infoFrame = new InfoFrame();
        CarController cc = new CarController(carFrame, infoFrame, new RandomMotorizedVehicleFactory());

            // Start the timer
            cc.timer.start();
    }
}
