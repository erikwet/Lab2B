package Controller;
import Model.MotorizedVehicle;
import Model.Saab95;
import Model.Scania;
import View.CarView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    // A list of cars, modify if needed
    public ArrayList<MotorizedVehicle> cars = new ArrayList<>();

    public CarController(CarView frame){
        this.frame = frame;
        this.frame.startAllCarsButton(new StartAllCarsListener());
        this.frame.stopAllCarsButton(new StopAllCarsListener());
        this.frame.gasButton(new GasAllCarsListener());
        this.frame.brakeButton(new BrakeAllCarsListener());
        this.frame.turboOnButton(new TurboOnListener());
        this.frame.turboOffButton(new TurboOffListener());
        this.frame.lowerFlatbedButton(new LowerFlatBedListener());
        this.frame.raiseFlatbedButton(new RaiseFlatBedListener());
        this.frame.addCarButton(new AddCarListener());
        this.frame.removeCarButton(new RemoveCarListener());
}
    //methods:

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
       private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).move();
                int x = (int) Math.round(cars.get(i).getX());
                int y = (int) Math.round(cars.get(i).getY());
                if(outOfBounds(x,y, frame.drawPanel.carImages.get(i))) {
                    cars.get(i).stopEngine();
                    setInBounds(cars.get(i), frame.drawPanel.carImages.get(i));
                    cars.get(i).oppositeDirection();
                    cars.get(i).startEngine();
                }
                frame.drawPanel.moveit(x, y, i);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                //System.out.println(cars.size());
            }
        }
    }

    private class StartAllCarsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startAllCars();
        }
    }

    private class StopAllCarsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            stopAllCars();
        }
    }

    private class GasAllCarsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gas(frame.gasAmount);
        }
    }

    private class BrakeAllCarsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            brake(frame.gasAmount);
        }
    }

    private class TurboOnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setTurboOn();
        }
    }

    private class TurboOffListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setTurboOff();
        }
    }

    private class LowerFlatBedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            lowerFlatbed();
        }
    }

    private class RaiseFlatBedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            raiseFlatbed();
        }
    }

    private class AddCarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Send method to factory
        }
    }
    private class RemoveCarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Send method to factory
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (MotorizedVehicle car : cars
                ) {
            car.gas(gas);
        }
    }

    /**
     * Calls the brake method for each car once
     * @param amount The amount of "power" the cars will brake with
     */
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorizedVehicle car : cars
        ) {
            car.brake(brake);
        }
    }

    /**
     * Try to call the setTurboOn method for each car once and runs if car is a Saab95
     */
    void setTurboOn(){
        for(MotorizedVehicle car: cars){
            if(car.getClass() == Saab95.class){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    /**
     * Try to call the setTurboOff method for each car once and runs if car is a Saab95
     */
    void setTurboOff(){
        for(MotorizedVehicle car: cars){
            if(car.getClass() == Saab95.class){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    /**
     * Try to call the raiseFlatbed method for each car once and runs if car is a Scania
     */
    void raiseFlatbed(){
        for(MotorizedVehicle car: cars){
            if(car.getClass() == Scania.class){
                ((Scania) car).raiseFlatbed();
            }
        }
    }

    /**
     * Try to call the lowerFlatbed method for each car once and runs if car is a Scania
     */
    void lowerFlatbed() {
        for(MotorizedVehicle car: cars){
            if(car.getClass() == Scania.class){
                ((Scania) car).lowerFlatbed();
            }
        }
    }

    /**
     * Calls the stopEngine method for each car once
     */
    void stopAllCars() {
        for(MotorizedVehicle car: cars){
            car.stopEngine();
        }
    }

    /**
     * Calls the startEngine method for each car once
     */
    void startAllCars() {
        for(MotorizedVehicle car: cars){
            car.startEngine();
        }
    }

    /**
     * Check if a car image is out of bounds
     * @param x X position of image
     * @param y Y position of image
     * @param carImage image of a car
     * @return True or False if the car is out of bounds
     */
    boolean outOfBounds(int x, int y, BufferedImage carImage){
        return x < 0 || x > (frame.drawPanel.getWidth()-carImage.getWidth()) || y < 0 || y > (frame.drawPanel.getHeight()-carImage.getHeight());
    }

    /**
     * Places a car in bounds
     * @param car The car that will be move in bounds
     * @param carImage The image of the car
     */
   public void setInBounds(MotorizedVehicle car, BufferedImage carImage){
        double x = (Math.min((frame.drawPanel.getWidth()-carImage.getWidth()), car.getX()));
        car.setX(Math.max(0, x));
        double y = (Math.min((frame.drawPanel.getHeight()-carImage.getHeight()), car.getY()));
        car.setY(Math.max(0, y));
    }
}