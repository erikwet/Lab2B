package Model;

import View.InfoFrame;

import java.util.ArrayList;

public interface Observer {

    void actOnSpeedChange(ArrayList<MotorizedVehicle> cars);

    void actOnListSizeChange(ArrayList<MotorizedVehicle> cars);

}
