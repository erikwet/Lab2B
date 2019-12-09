package Model;

import java.util.Deque;

/**
 * @author Oscar Arvidson and Erik Wetter
 * A workshop objects that can hold Cars och subclasses of car
 */
public class Workshop <T extends Car> implements ITransportableHolder<T>{

    private TransportableHolder transportableHolderParent;

    /**
     * @param maxStoredObjects Number of max allowed stored objects
     * @param maxTransportableWidth Max allowed width of transported object
     * @param maxTransportableHeight Max allowed height of transported object
     * @param maxTransportableLength Max allowed length of transported object
     * @param x X Position of the workshop in world
     * @param y Y Position of the workshop in world
     */
    public Workshop(int maxStoredObjects, double maxTransportableWidth, double maxTransportableHeight, double maxTransportableLength, double x, double y) {
        transportableHolderParent = new TransportableHolder(maxStoredObjects, maxTransportableWidth, maxTransportableHeight, maxTransportableLength, x, y);
    }

    /**
     * Opens the loading point of the workshop
     */
    public void openLoadingPoint() {
        transportableHolderParent.openLoadingPoint();
    }

    /**
     * Closes the loading point of the workshop
     */
    public void closeLoadingPoint() {
        transportableHolderParent.closeLoadingPoint();
    }

    /**
     * Gets the workshops transporter storage from transporter holder
     * @return The Transporter storage of workshop
     */
    public Deque<T> getTransporterStorageList() {
        return transportableHolderParent.transporterStorageList;
    }

    /**
     * Loads a transportable object into the workshop
     * @param transportable The transportable object being loaded.
     */
    @Override
    public void loadTransportable(T transportable) {
        transportableHolderParent.loadTransportable(transportable);
    }

    /**
     * Unloads a transportable object out from the workshop
     */
    @Override
    public void unloadTransportable() {
        transportableHolderParent.unloadTransportable();
    }

    /**
     * Gets x position of the workshop in the world.
     * @return X position of the workshop in the world.
     */
    @Override
    public double getX() {
        return transportableHolderParent.getX();
    }

    /**
     * Gets y position of the workshop in the world.
     * @return Y position of the workshop in the world.
     */
    @Override
    public double getY() {
        return transportableHolderParent.getY();
    }
}