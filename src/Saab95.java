import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Implemented model of the Car superclass. Implements a turbo feature.
 */
public class Saab95 implements IVehicle, Movable {

    private boolean turboOn;

    private final Car car;

    /**
     * Sets the car's color to red, model name to "Saab 95", number of doors to 2, engine power to 125,
     * position to (0, 0) and stops the engine (sets current speed to 0).
     */
    public Saab95(){
        car = new Car(2, Color.RED,125,"Saab 95", 0,0);
        stopEngine();
    }

    /**
     * Returns true if turbo is on.
     * @return state of the car's turbo
     */
    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     * Turns on the car's turbo feature.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns off the car's turbo feature.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Returns the factor by which the speed should be modified when it accelerates/decelerates. Affected by the state
     * of the car's turbo.
     * @return factor to modify currentSpeed with during acceleration/deceleration
     */
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return car.getEnginePower() * 0.01 * turbo;
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
    @Override
    public void move() {
        car.move();
    }

    /**
     * Makes the car turn 90 degrees to the left. Increases the car's direction by PI/2 radians.
     */
    @Override
    public void turnLeft() {
        car.turnLeft();
    }

    /**
     * Makes the car turn 90 degrees to the right. Decreases the car's direction by PI/2 radians.
     */
    @Override
    public void turnRight() {
        car.turnRight();
    }
}
