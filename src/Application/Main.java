package Application;

import Controller.CarController;
import Model.Saab95;
import Model.Scania;
import Model.Volvo240;
import View.CarView;

public class Main {

    public static void main(String[] args) {
        // Instance of this class
        CarView frame = new CarView("Sim 1.0");
        CarController cc = new CarController(frame);

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self

        // Start the timer
        cc.timer.start();
    }
}
