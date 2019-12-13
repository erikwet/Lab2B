package Model;

import java.awt.*;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Subclass of FlatbedTruck
 */
public class Scania extends FlatbedTruck {

    public Scania(double x, double y) {
        super(Direction.EAST, x, y, 2, 500, Color.cyan, "Scania", 2.5, 5, 10, 70);
    }

    /**
     * Sets speed factor for a Scania
     * @return The speed factor
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.002;
    }
}
