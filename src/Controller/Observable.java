package Controller;

import Model.MotorizedVehicle;

import java.util.ArrayList;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Interface for Observables
 */

public interface Observable {
    /**
     * Adds observers
     * @param observer An object that implements IObserver
     */
    void addObserver(IObserver observer);

    /**
     * Notifies observers of speed changes
     * @param cars ArrayList with motorizedVehicles
     */
    void notifyObserversSpeed(ArrayList<MotorizedVehicle> cars);

    /**
     * Notifies observers of list changes
     * @param cars ArrayList with motorizedVehicles
     */
    void notifyObserversListSize(ArrayList<MotorizedVehicle> cars);

}
