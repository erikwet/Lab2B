package Model;
import java.awt.*;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Subclass of Model.Car. Represents a car of model Model.Volvo240
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240(double x, double y){
        super(Direction.EAST, x, y, 5, 100, Color.white, "Volvo240", 1.8, 1.6, 4.5);
    }

    /**
     * Calculates the speed factor (overrides method Car)
     * @return The speed factor (factor the speed is changed by)
     */
    @Override
    protected double speedFactor(){
        return super.speedFactor() * trimFactor;
    }
}