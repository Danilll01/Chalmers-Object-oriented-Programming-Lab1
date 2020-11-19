/**
 * Subtype of vehicle, usually slower and bigger in size. Implements no additional functionality.
 */
public abstract class Truck extends Vehicle
{

    /**
     * Returns the factor by which the speed should be modified when it accelerates/decelerates.
     *
     * @return factor to modify currentSpeed with during acceleration/deceleration
     */
    protected abstract double speedFactor();
}
