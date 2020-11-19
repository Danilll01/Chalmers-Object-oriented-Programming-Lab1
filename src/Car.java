import java.awt.*;
import java.awt.geom.Point2D;


/**
 * Collection of attributes and functionality of a car, with a position in a 2D space and a direction (angle).
 *
 * Attributes consist of amount of doors, color, engine power, current speed, model name, x position, y, position and direction angle in radians.
 */
public abstract class Car extends Vehicle
{
    /**
     * Returns the factor by which the speed should be modified when it accelerates/decelerates.
     * @return factor to modify currentSpeed with during acceleration/deceleration
     */
    protected abstract double speedFactor();


}
