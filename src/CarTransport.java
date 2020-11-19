import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implements the idea of a Car transport that can transport cars on itself
 * Has a ramp that can be raised and lowered when transport is stationary, cars can be loaded and unloaded when the ramp is lowered
 * extends Truck
 */

public class CarTransport extends Truck
{
    /**
     * Cars stored on the car transporter.
     */
    private final Deque<Car> storedCars;
    /**
     * True if the ramp of the car transporter is lowered
     */
    private boolean rampLowered;

    /**
     * Sets attributes to their default values.
     */
    public CarTransport(){
        super(Color.PINK, "Car transporter", 2, 220, 0, 0);

        storedCars = new ArrayDeque<>(3);
        rampLowered = false;
    }

    /**
     * Passes constructor parameters to super, creates a stack and set rampLowered to false.
     */
    public CarTransport(Color color, String modelName, int nDoors, double enginePower, double posX, double posY) {
        super(color, modelName, nDoors, enginePower, posX, posY);

        storedCars = new ArrayDeque<>(3);
        rampLowered = false;
    }

    /**
     * Overrides Vehicle class' move method. Now checks if the ramp is up before moving, and updates the position of every loaded car,
     * as the cannot move by themselves.
     */
    @Override
    public void move(){
        if(rampLowered || !movable) return;
        super.move();
        for(Car car : storedCars){
            car.loadedMove();
        }
    }

    /**
     * Raises the ramp
     */
    public void raiseRamp(){
        rampLowered = false;
    }

    /**
     * Lowers the ramp
     */
    public void lowerRamp(){
        if(getCurrentSpeed() > 0.01) return;
        rampLowered = true;
    }

    /**
     * Loads given car onto the car transporter. Will not load if the transporter is full, or if the car is not within a
     * distance of 5 l.u.
     * @param car car to be loaded
     */
    public void loadCar(Car car){
        if(storedCars.size() >= 3 || !rampLowered || car.getCurrentSpeed() > 0.01) return;
        Point2D current = getPos();
        Point2D carPos = car.getPos();

        double distX = Math.abs(current.getX() - carPos.getX());
        double distY = Math.abs(current.getY() - carPos.getY());

        double distance = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));

        if(distance > 5) return;

        car.load(this);
        storedCars.add(car);
    }

    /**
     * Unloads last car from transport unless transport is empty.
     */
    public void unloadCar(){
        if(storedCars.isEmpty() || !rampLowered) return;

        storedCars.pop().unload();
    }

    /**
     * Returns the factor by which the speed should be modified when it accelerates/decelerates.
     *
     * @return factor to modify currentSpeed with during acceleration/deceleration
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
