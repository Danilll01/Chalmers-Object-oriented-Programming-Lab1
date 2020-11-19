/**
 * Defines an object capable of being loaded onto another object.
 */
public interface ILoadable {

    /**
     * To be used as move method if the object is loaded. Provides additional/other functionality.
     */
    void loadedMove();

    /**
     * Loads onto object given as argument.
     * @param transport object to be loaded onto
     */
    void load(CarTransport transport);

    /**
     * Method to be called when a car gets unloaded from a transporter.
     */
    void unload();

}
