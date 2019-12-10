package Model;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Interface for all motorized vehicles in the world
 * Extends the interface IMovable
 */
public interface IMotorizedVehicle extends IMovable {

    /**
     * Increases speed of a motorized vehicle.
     * @param amount The amount the speed should increase with
     */
    void gas(double amount);

    /**
     * Decrease speed of a motorized vehicle.
     * @param amount The amount the speed should decrease with
     */
    void brake(double amount);

    /**
     * Starts engine of a motorized vehicle
     */
    void startEngine();

    /**
     * Stops engine of a motorized vehicle
     */
    void stopEngine();
}
