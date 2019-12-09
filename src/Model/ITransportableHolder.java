package Model;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Interface for all objects that can hold a transportable object that extends the interface Model.IPositionable.
 */
public interface ITransportableHolder<T> extends IPositionable {

    /**
     * Loads a transportable object on/in a transportableHolder.
     * @param transportable The transportable object being loaded.
     */
    void loadTransportable(T transportable);

    /**
     * Unloads a transportable object in the same order it was loaded.
     */
    void unloadTransportable();
}
