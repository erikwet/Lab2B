package View;

import Model.MotorizedVehicle;

import java.util.ArrayList;

public class Observable {
    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    protected void notifyObserversSpeed(ArrayList<MotorizedVehicle> cars) {
        for(Observer observer : observers) {
            observer.actOnSpeedChange(cars);
        }
    }
    protected void notifyObserversListSize(ArrayList<MotorizedVehicle> cars) {
        for(Observer observer : observers) {
            observer.actOnListSizeChange(cars);
        }
    }
}
