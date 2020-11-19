import java.awt.geom.Point2D;

/** List of cars
 * Specifies that cars can be loaded and unloaded.
 */
public interface ICar
{
    /**
     * Method that is called when the car gets loaded onto a car transporter. Sets relevant attributes to specified values
     * to keep track of the transporter's speed and other attributes in the future.
     * @param transport car transporter that the car is loaded onto
     */
    void loadCar(CarTransport transport);
    /**
     * Method to be called when the car gets unloaded from a car transporter.
     */
    void unloadCar();

    /**
     * Returns the position of the car.
     */
    Point2D.Double getPos();
}
