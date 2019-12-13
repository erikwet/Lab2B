package Controller;

import Model.MotorizedVehicle;
import java.util.ArrayList;

public interface Observable {

    void addObserver(IObserver observer);

    void notifyObserversSpeed(ArrayList<MotorizedVehicle> cars);

    void notifyObserversListSize(ArrayList<MotorizedVehicle> cars);

}
