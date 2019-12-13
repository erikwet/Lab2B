package Controller;

import Model.MotorizedVehicle;
import java.util.ArrayList;

 public interface IObserver {

    void actOnSpeedChange(ArrayList<MotorizedVehicle> cars);

    void actOnListSizeChange(ArrayList<MotorizedVehicle> cars);

}
