import java.awt.*;

/**
 * An implementation of a truck type vehicle model. Has a platform that can be raised and lowered.
 */
public class Scania implements IVehicle, Movable
{
    /**
     * Delegate for truck functionality.
     */
    private final Truck truck;

    /**
     * Angle of the truck's platform, can be lowered/raised.
     */
    private int platformAngle;

    /**
     * Initiates Scania object as a pink truck, with the engine power of 200 and 2 doors, at x:0 and y:0
     */
    public Scania() {
        this.truck = new Truck(2, Color.PINK, 200, "Scania-R", 0, 0);
        platformAngle = 0;
    }

    /**
     * Returns the factor by which the speed should be modified when it accelerates/decelerates. Affected by the truck's
     * trim factor.
     *
     * @return factor to modify currentSpeed with during acceleration/deceleration
     */
    private double speedFactor()
    {
        return truck.getEnginePower() * 0.02;
    }

    /**
     * Sets the speed of the vehicle to 0.1. Makes the vehicle start moving.
     */
    public void startEngine() {
        truck.startEngine();
    }

    /**
     * Sets the speed of the vehicle to 0. Makes the vehicle stop moving.
     */
    public void stopEngine() {
        truck.stopEngine();
    }

    /**
     * Makes the vehicle accelerate, increases its current speed.
     *
     * @param amount amount to increase the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void gas(double amount) {
        truck.gas(amount);
    }

    /**
     * Makes the vehicle decelerate, decreases its current speed.
     *
     * @param amount amount to decrease the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void brake(double amount) {
        truck.brake(amount);
    }

    /**
     * Moves the object.
     */
    public void move() {
        if(platformAngle == 0) truck.move();
    }

    /**
     * Makes the object turn left.
     */
    public void turnLeft() {
        truck.turnLeft();
    }

    /**
     * Makes te object turn right.
     */
    public void turnRight() {
        truck.turnRight();
    }

    /**
     * Raises the angle of the truck's platform by specified amount of degrees but only if the truck is stationary.
     * If the truck is moving, then the platform will not raise itself.
     * @param amount angle in degrees
     */
    public void raisePlatform(int amount)
    {
        if(amount < 0 || truck.getCurrentSpeed() < 0.001) return;
        int newValue = platformAngle + amount;

        if (newValue > 70) platformAngle = 70;
        else platformAngle = newValue;
    }

    /**
     * Lowers the angle of the truck's platform by specified amount of degrees,  but only if the truck is stationary.
     * If the truck is moving, then the platform will not lower itself.
     * @param amount angle in degrees
     */
    public void lowerPlatform(int amount)
    {
        if(amount < 0 || truck.getCurrentSpeed() < 0.001) return;
        int newValue = platformAngle - amount;

        if (newValue < 0) platformAngle = 0;
        else platformAngle = newValue;
    }

}
