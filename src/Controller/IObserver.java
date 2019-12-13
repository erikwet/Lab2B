package Controller;

import Model.MotorizedVehicle;
import java.util.ArrayList;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Interface for all Observers
 */
 public interface IObserver {

    /**
     * Update something based on speed changes
     * @param cars ArrayList with motorizedVehicles
     */
    void actOnSpeedChange(ArrayList<MotorizedVehicle> cars);

    /**
     * Update something based on car list changes
     * @param cars ArrayList with motorizedVehicles
     */
    void actOnListSizeChange(ArrayList<MotorizedVehicle> cars);

}
