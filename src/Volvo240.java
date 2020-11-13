import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Implemented model of the Car superclass. Implements a trim feature.
 */
public class Volvo240 implements IVehicle, Movable {

    private final Car car;

    /**
     * Modifies the rate at which the car accelerates/decelerates.
     */
    private final double trimFactor;

    /**
     * Sets this cars color to black, model name to "Volvo 240", number of doors to 4, engine power to 100, stops the engine and sets start position to 0,0.
     */
    public Volvo240(double trimFactor) {
        car = new Car(0, 0, 4, Color.BLACK, 100, "Volvo 240");
        this.trimFactor = trimFactor;
        stopEngine();
    }

    /**
     * Returns the car trim factor of the car.
     *
     * @return volvo's trim factor
     */
    public double getTrimFactor() {
        return trimFactor;
    }

    /**
     * Returns the factor by which the speed should be modified when it accelerates/decelerates. Affected by the car's
     * trim factor.
     *
     * @return factor to modify currentSpeed with during acceleration/deceleration
     */
    private double speedFactor() {
        return car.getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * Sets the speed of the vehicle to 0.1. Makes the vehicle start moving. Should be called when the vehicle isn't moving.
     */
    public void startEngine() {
        car.startEngine();
    }

    /**
     * Sets the speed of the vehicle to 0. Makes the vehicle stop moving.
     */
    public void stopEngine() {
        car.stopEngine();
    }

    /**
     * Makes the vehicle accelerate, increases its current speed.
     * @param amount amount to increase the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void gas(double amount) {
        car.gas(amount * speedFactor());
    }

    /**
     * Makes the vehicle decelerate, decreases its current speed.
     * @param amount amount to decrease the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void brake(double amount) {
        car.brake(amount * speedFactor());
    }

    /**
     * Returns the number of doors on the car.
     * @return the number of doors on the car
     */
    public int getNrDoors(){
        return car.getNrDoors();
    }

    /**
     * Returns the engine power of the car.
     * @return the engine power of the car
     */
    public double getEnginePower(){
        return car.getEnginePower();
    }

    /**
     * Returns the current total velocity of the car.
     * @return current velocity of the car
     */
    public double getCurrentSpeed(){
        return car.getCurrentSpeed();
    }

    /**
     * Returns the position of the car.
     * @return a Point with x and y coordinates
     */
    public Point2D getPos() {
        return car.getPos();
    }

    /**
     * Returns the current direction of the car's velocity in radians.
     * @return the car's velocity's direction in radians
     */
    public double getDirection() {
        return car.getDirection();
    }

    /**
     * Updates the car's position in the 2D plane according to it's currentSpeed and direction.
     */
    public void move() {
        car.move();
    }

    /**
     * Makes the car turn 90 degrees to the left. Increases the car's direction by PI/2 radians.
     */
    public void turnLeft() {
        car.turnLeft();
    }

    /**
     * Makes the car turn 90 degrees to the right. Decreases the car's direction by PI/2 radians.
     */
    public void turnRight() {
        car.turnRight();
    }
}