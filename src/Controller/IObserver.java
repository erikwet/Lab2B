package Controller;

import Model.MotorizedVehicle;
import java.util.ArrayList;

/**
 * @author Oscar Arvidson & Erik Wetter
 * Interface for all Observers
 */
 public interface IObserver {

    /**
     * 
     * @param cars
     */
    void actOnSpeedChange(ArrayList<MotorizedVehicle> cars);

    void actOnListSizeChange(ArrayList<MotorizedVehicle> cars);

}
