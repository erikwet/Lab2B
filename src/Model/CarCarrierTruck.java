package Model;

import java.awt.*;
import java.util.Deque;

/**
 * @author Oscar Arvidson and Erik Wetter
 * A subclass of Model.MotorizedVehicle that consist of methods used in car carrier truck.
 * Also implements the interface ITransportableHolder and uses parametric type T which extends interface Model.ITransportable.
 */
public abstract class CarCarrierTruck<T extends ITransportable> extends MotorizedVehicle implements ITransportableHolder<T> {

    final private TransportableHolder transportableHolderParent;
    private boolean isRampUp;

    /**
     * @param currentDirection Current direction for a truck
     * @param x X Position of truck in world
     * @param y Y Position of truck in world
     * @param nrDoors Number of doors on the truck
     * @param enginePower Engine power of the truck
     * @param color Color of the truck
     * @param modelName Model name of the truck
     * @param widthMeter Width in meters of the truck
     * @param heightMeter Height in meters of the truck
     * @param lengthMeter Length in meters of the truck
     * @param maxStoredObjects Number of max allowed stored objects
     * @param maxTransportableWidth Max allowed width of transported object
     * @param maxTransportableHeight Max allowed height of transported object
     * @param maxTransportableLength Max allowed length of transported object
     */
    public CarCarrierTruck(Direction currentDirection, double x, double y, int nrDoors, double enginePower, Color color, String modelName, double widthMeter, double heightMeter, double lengthMeter, int maxStoredObjects, double maxTransportableWidth, double maxTransportableHeight, double maxTransportableLength) {
       super(currentDirection, x, y, nrDoors, enginePower, color, modelName, widthMeter, heightMeter, lengthMeter);
        transportableHolderParent = new TransportableHolder(maxStoredObjects, maxTransportableWidth, maxTransportableHeight, maxTransportableLength, x, y);
    }

    /**
     * Raises ramp on the truck
     */
    public void raiseRamp(){
        transportableHolderParent.closeLoadingPoint();
        isRampUp = true;
    }

    /**
     * Lowers ramp on the truck
     */
    public void lowerRamp(){
        if(getCurrentSpeed() == 0) {
            transportableHolderParent.openLoadingPoint();
            isRampUp = false;
        }
    }

    /**
     * Change current speed of truck if ramp is up
     * @param speed Current speed of truck
     */
    @Override
    public void setCurrentSpeed(double speed){
        if(!isRampUp) {
            super.setCurrentSpeed(0);
        }else {
            super.setCurrentSpeed(speed);
        }
    }

    /**
     * Moves truck depending on current speed.
     */
    @Override
    public void move(){
        switch (getCurrentDirection()){
            case NORTH:
                transportableHolderParent.y -= getCurrentSpeed();
                break;
            case EAST:
                transportableHolderParent.x += getCurrentSpeed();
                break;
            case SOUTH:
                transportableHolderParent.y += getCurrentSpeed();
                break;
            case WEST:
                transportableHolderParent.x -= getCurrentSpeed();
                break;
        }
        updateStoredObjectsPosition();
    }


    /**
     * @return Transporters storage list
     */
    public Deque<T> getTransporterStorageList() {
        return transportableHolderParent.transporterStorageList;
    }

    /**
     * Loads a transportable on the truck
     * @param transportable The transportable object being loaded.
     */
    @Override
    public void loadTransportable(T transportable) {
        transportableHolderParent.loadTransportable(transportable);
    }

    /**
     * Unload s a transportable off the truck
     */
    @Override
    public void unloadTransportable() {
        transportableHolderParent.unloadTransportable();
    }

    /**
     * Updates position of objects in transporters storage with the trucks x and y
     */
    public void updateStoredObjectsPosition(){
        transportableHolderParent.updateStoredObjectsPosition(getX(), getY());
    }

    /**
     * Sets x and overrides method from movable in order to let transportableHolder control the x value
     * @param x X position the car carrier should get.
     */
    @Override
    public void setX(double x){
        transportableHolderParent.x = x;
    }

    /**
     * Sets y and overrides method from movable in order to let transportableHolder control the y value
     * @param y Y position the car carrier should get.
     */
    @Override
    public void setY(double y){
        transportableHolderParent.y = y;
    }

    @Override
    public double getX() {
        return transportableHolderParent.x;
    }

    @Override
    public double getY() {
        return transportableHolderParent.y;
    }
}
