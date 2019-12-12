package Model;

import java.util.Random;

public class MotorizedVehicleFactory implements IMotorizedVehicleFactory {

    @Override
    public MotorizedVehicle createMotorizedVehicle() {
        Random rand = new Random();
        int randomInt = rand.nextInt(3);
        System.out.println(randomInt);
        if(randomInt == 0){
            return new Volvo240();
        }
        else if (randomInt == 1){
            return new Saab95();
        }
        else return new Scania();
    }

}
