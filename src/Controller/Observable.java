package Controller;

import Model.MotorizedVehicle;
import java.util.ArrayList;

public abstract class Observable {
    private ArrayList<IObserver> observers = new ArrayList<>();

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    protected void notifyObserversSpeed(ArrayList<MotorizedVehicle> cars) {
        for(IObserver observer : observers) {
            observer.actOnSpeedChange(cars);
        }
    }
    protected void notifyObserversListSize(ArrayList<MotorizedVehicle> cars) {
        for(IObserver observer : observers) {
            observer.actOnListSizeChange(cars);
        }
    }
}
