package Model;

import View.InfoFrame;

import javax.swing.*;
import java.util.ArrayList;

public class Observable {
    private ArrayList<Observer> observers = new ArrayList<>();

    /*InfoFrame infoFrame;

    public Observable(InfoFrame infoFrame) {
        this.infoFrame = infoFrame;
    }*/

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
