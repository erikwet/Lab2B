package Model;

import java.util.Random;

public class MotorizedVehicleFactory implements IMotorizedVehicleFactory {

    @Override
    public MotorizedVehicle createMotorizedVehicle() {
        /*Random rand = new Random();
        System.out.println(rand);
        int randomInt = rand.nextInt(3);
        if(randomInt == 0){
            return new Volvo240();
        }
        else if (randomInt == 1){
            return new Saab95();
        }
        else return new Scania();*/
        return new Volvo240();
    }

}
