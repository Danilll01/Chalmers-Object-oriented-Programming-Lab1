import java.awt.*;

/**
 * Subtype of vehicle, usually slower and bigger in size. Implements no additional functionality.
 */
public abstract class Truck extends Vehicle
{

    /**
     * Passes constructor parameters to super.
     */
    public Truck(Color color, String modelName, int nDoors, double enginePower, double posX, double posY) {
        super(color, modelName, nDoors, enginePower, posX, posY);
    }

    /**
     * Returns the factor by which the speed should be modified when it accelerates/decelerates.
     *
     * @return factor to modify currentSpeed with during acceleration/deceleration
     */
    protected abstract double speedFactor();
}
