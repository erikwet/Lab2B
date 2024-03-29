package Controller;
import Model.*;
import View.CarView;
import View.InfoFrame;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

/**
 * @author Oscar Arvidson and Erik Wetter
 * Class that controls interactions between model, view and the user inputs
 */
public class CarController implements Observable {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());

    // The frames that represents this instance View of the MVC pattern
    public CarView frame;
    public InfoFrame infoFrame;
    // A list of motorizedVehicles
    private ArrayList<MotorizedVehicle> cars = new ArrayList<>();
    private ArrayList<IObserver> observers = new ArrayList<>();
    // A factory that creates motorizedVehicles
    private IMotorizedVehicleFactory motorizedVehicleFactory;

    /**
     * @param frame An instance of CarView
     * @param infoFrame An instance if InfoView
     * @param motorizedVehicleFactory An instance of an object that implements IMotorizedVehicleFactory
     */
    public CarController(CarView frame, InfoFrame infoFrame, IMotorizedVehicleFactory motorizedVehicleFactory){
        this.frame = frame;
        this.infoFrame = infoFrame;
        this.motorizedVehicleFactory = motorizedVehicleFactory;
        createActionListeners();
        addObserver(infoFrame);
}

    /**
     * Class that updates all motorizedVehicles positions in the list car and tells the CarView to update itself
     */
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
                    notifyObserversSpeed(cars);
                }
                frame.drawPanel.moveit(x, y, i);
                // repaint() calls the paintComponent method of the panel
            }
            frame.drawPanel.repaint();

        }
    }

    /**
     * Create all action listeners for the buttons in CarFrame.
     */
    private void createActionListeners() {

        frame.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(frame.getGasAmount());
            }
        });

        frame.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(frame.getGasAmount());
            }
        });

        frame.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOn();
            }
        });

        frame.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOff();
            }
        });

        frame.getLiftBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                raiseFlatbed();
            }
        });

        frame.getLowerBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerFlatbed();
            }
        });

        frame.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startAllCars();
            }
        });

        frame.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAllCars();
            }
        });

        frame.getAddCarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cars.size() < 10) {
                    MotorizedVehicle newCar = motorizedVehicleFactory.createMotorizedVehicle();
                    cars.add(newCar);
                    addCarImage(newCar);
                    notifyObserversListSize(cars);
                }
            }
        });

        frame.getRemoveCarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cars.size() > 0){
                    int index = cars.size()-1;
                    cars.remove(index);
                    frame.drawPanel.carImages.remove(index);
                    notifyObserversListSize(cars);
                }
            }
        });
    }

    // Calls the gas method for each car once
    private void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (MotorizedVehicle car : cars) {
            car.gas(gas);
        }
        notifyObserversSpeed(cars);
    }

    /**
     * Calls the brake method for each car once
     * @param amount The amount of "power" the cars will brake with
     */
    private void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorizedVehicle car : cars) {
            car.brake(brake);
        }
        notifyObserversSpeed(cars);
    }

    /**
     * Try to call the setTurboOn method for each car once and runs if car is a Saab95
     */
    private void setTurboOn(){
        for(MotorizedVehicle car: cars){
            if(car.getClass() == Saab95.class){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    /**
     * Try to call the setTurboOff method for each car once and runs if car is a Saab95
     */
    private void setTurboOff(){
        for(MotorizedVehicle car: cars){
            if(car.getClass() == Saab95.class){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    /**
     * Try to call the raiseFlatbed method for each car once and runs if car is a Scania
     */
    private void raiseFlatbed(){
        for(MotorizedVehicle car: cars){
            if(car.getClass() == Scania.class){
                ((Scania) car).raiseFlatbed();
            }
        }
    }

    /**
     * Try to call the lowerFlatbed method for each car once and runs if car is a Scania
     */
    private void lowerFlatbed() {
        for(MotorizedVehicle car: cars){
            if(car.getClass() == Scania.class){
                ((Scania) car).lowerFlatbed();
            }
        }
    }

    /**
     * Calls the stopEngine method for each car once
     */
    private void stopAllCars() {
        for(MotorizedVehicle car: cars){
            car.stopEngine();
        }
        notifyObserversSpeed(cars);
    }

    /**
     * Calls the startEngine method for each car once
     */
    private void startAllCars() {
        for(MotorizedVehicle car: cars){
            car.startEngine();
        }
        notifyObserversSpeed(cars);
    }

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void notifyObserversSpeed(ArrayList<MotorizedVehicle> cars) {
        for(IObserver observer : observers) {
            observer.actOnSpeedChange(cars);
        }
    }
    public void notifyObserversListSize(ArrayList<MotorizedVehicle> cars) {
        for(IObserver observer : observers) {
            observer.actOnListSizeChange(cars);
        }
    }

    /**
     * Check if a car image is out of bounds
     * @param x X position of image
     * @param y Y position of image
     * @param carImage image of a car
     * @return True or False if the car is out of bounds
     */
    private boolean outOfBounds(int x, int y, BufferedImage carImage){
        return x < 0 || x > (frame.drawPanel.getWidth()-carImage.getWidth()) || y < 0 || y > (frame.drawPanel.getHeight()-carImage.getHeight());
    }

    /**
     * Places a car in bounds
     * @param car The car that will be move in bounds
     * @param carImage The image of the car
     */
    private void setInBounds(MotorizedVehicle car, BufferedImage carImage){
        double x = (Math.min((frame.drawPanel.getWidth()-carImage.getWidth()), car.getX()));
        car.setX(Math.max(0, x));
        double y = (Math.min((frame.drawPanel.getHeight()-carImage.getHeight()), car.getY()));
        car.setY(Math.max(0, y));
    }

    /**
     * Adds an image to carImages based on model name of MotorizedVehicle
     * @param car A motorized vehicle
     */
    private void addCarImage(MotorizedVehicle car){
       String image = "pics/" + car.getModelName() + ".jpg";
        System.out.println(image);
        try {
            frame.drawPanel.carImages.add(ImageIO.read(CarView.class.getResourceAsStream(image)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}