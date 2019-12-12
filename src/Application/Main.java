package Application;
import Controller.CarController;
import Model.*;
import View.CarView;
import View.InfoPanel;

public class Main {

    public static void main(String[] args) {
        // Instance of this class
        CarView carFrame = new CarView("Sim 1.0");
        InfoPanel infoFrame = new InfoPanel();
        CarController cc = new CarController(carFrame, infoFrame, new MotorizedVehicleFactory());

            // Start the timer
            cc.timer.start();
    }
}
