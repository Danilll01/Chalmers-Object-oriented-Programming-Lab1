import java.awt.*;
import java.awt.geom.Point2D;
import Helpers.*;


/**
 * Collection of attributes and functionality of a car, with a position in a 2D space and a direction (angle).
 *
 * Attributes consist of amount of doors, color, engine power, current speed, model name, x position, y, position and direction angle in radians.
 */
public class Car implements Movable, IVehicle
{

    /**
     * Keeps track of the position and velocity of the car.
     */
    PositionHelper pHelper;

    /**
     * Keeps track of the car's color, model name, engine power and amount of doors
     */
    VehicleHelper vHelper;

    /**
     * Sets specified attributes to given arguments, creates a new car.
     * @param posX x value of initial position
     * @param posY y value of initial position
     * @param nrDoors number of doors on the car
     * @param color color of the car
     * @param enginePower car's engine power
     * @param modelName car's model name
     */
    public Car(double posX, double posY, int nrDoors, Color color, double enginePower, String modelName)
    {
        pHelper = new PositionHelper(0, posX, posY, 0);
        vHelper = new VehicleHelper(nrDoors, color, modelName, enginePower);
    }

    /**
     * Increases the car's total velocity. Velocity cannot be increased beyond enginePower.
     * @param amount amount to increase the car's velocity by
     */
    private void incrementSpeed(double amount){
        pHelper.setCurrentSpeed(Math.min(pHelper.getCurrentSpeed() + amount, vHelper.getEnginePower()));

    }

    /**
     * Decreases the car's total velocity. Velocity cannot be decreased to below zero.
     * @param amount amount to decrease the car's velocity by
     */
    private void decrementSpeed(double amount) {
        pHelper.setCurrentSpeed(Math.max(pHelper.getCurrentSpeed() - amount, 0));
    }

    /**
     * Updates the car's position in the 2D plane according to it's currentSpeed and direction.
     */
    public void move(){
        double x = pHelper.getCurrentSpeed() * Math.cos(pHelper.getDirection());
        double y = pHelper.getCurrentSpeed() * Math.sin(pHelper.getDirection());
        pHelper.setPosition(pHelper.getPos().getX() + x, pHelper.getPos().getY() + y);
    }

    /**
     * Makes the car turn 90 degrees to the left. Increases the car's direction by PI/2 radians.
     */
    public void turnLeft(){
        pHelper.setDirection(pHelper.getDirection() + Math.PI / 2);
    }

    /**
     * Makes the car turn 90 degrees to the right. Decreases the car's direction by PI/2 radians.
     */
    public void turnRight(){
        pHelper.setDirection(pHelper.getDirection() - Math.PI / 2);
    }

    /**
     * Sets the current speed of the car to 0. Makes the car stop moving.
     */
    public void stopEngine() { pHelper.setCurrentSpeed(0); }

    /**
     * Sets the current speed of the car to 0.1. Make the car start moving. Should be called when the car isn't moving.
     */
    public void startEngine() { pHelper.setCurrentSpeed(0.1); }

    /**
     * Makes the car accelerate, increases its current speed. Only accepts
     * @param amount amount to increase the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void gas(double amount){
        if(amount >= 1 || amount < 0) throw new IllegalArgumentException("gas amount has to be between 0 and 1");

        incrementSpeed(amount);
    }

    /**
     * Makes the car decelerate, decreases its current speed.
     * @param amount amount to decrease the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void brake(double amount){
        if(amount >= 1 || amount < 0) throw new IllegalArgumentException("break amount has to be between 0 and 1");

        decrementSpeed(amount);
    }

}
