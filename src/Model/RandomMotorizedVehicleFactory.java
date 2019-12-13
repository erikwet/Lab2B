package Model;

import java.util.Random;

public class RandomMotorizedVehicleFactory implements IMotorizedVehicleFactory {

    @Override
    public MotorizedVehicle createMotorizedVehicle() {
        Random rand = new Random();
        int randomInt = rand.nextInt(3);
        int randomX = rand.nextInt(680);
        int randomY = rand.nextInt(490);
        if(randomInt == 0){
            return new Volvo240(randomX, randomY);
        }
        else if (randomInt == 1){
            return new Saab95(randomX, randomY);
        }
        else return new Scania(randomX, randomY);
    }
}
