import java.awt.*;
import java.awt.geom.Point2D;


/**
 * Collection of attributes and functionality of a car, with a position in a 2D space and a direction (angle).
 *
 * Attributes consist of amount of doors, color, engine power, current speed, model name, x position, y, position and direction angle in radians.
 */
public class Car implements Movable, IVehicle
{
    private final Vehicle vehicle;

    /**
     * Sets specified attributes to given arguments, creates a new car.
     * @param posX x value of initial position
     * @param posY y value of initial position
     * @param nrDoors number of doors on the car
     * @param color color of the car
     * @param enginePower car's engine power
     * @param modelName car's model name
     */
    public Car(int nrDoors, Color color, double enginePower, String modelName, double posX, double posY) {
        vehicle = new Vehicle(nrDoors, color, modelName, enginePower, posX, posY);
    }

    /**
     * Increases the car's total velocity. Velocity cannot be increased beyond enginePower.
     * @param amount amount to increase the car's velocity by
     */
    private void incrementSpeed(double amount){
        vehicle.incrementSpeed(amount);
    }

    /**
     * Decreases the car's total velocity. Velocity cannot be decreased to below zero.
     * @param amount amount to decrease the car's velocity by
     */
    private void decrementSpeed(double amount) {
        vehicle.decrementSpeed(amount);
    }

    /**
     * Updates the car's position in the 2D plane according to it's currentSpeed and direction.
     */
    public void move(){
        vehicle.move();
    }

    /**
     * Makes the car turn 90 degrees to the left. Increases the car's direction by PI/2 radians.
     */
    public void turnLeft(){
        vehicle.turnLeft();
    }

    /**
     * Makes the car turn 90 degrees to the right. Decreases the car's direction by PI/2 radians.
     */
    public void turnRight(){
        vehicle.turnRight();
    }

    /**
     * Sets the current speed of the car to 0. Makes the car stop moving.
     */
    public void stopEngine() { vehicle.stopEngine(); }

    /**
     * Sets the current speed of the car to 0.1. Make the car start moving. Should be called when the car isn't moving.
     */
    public void startEngine() { vehicle.startEngine(); }

    /**
     * Makes the car accelerate, increases its current speed. Only accepts
     * @param amount amount to increase the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void gas(double amount){
        vehicle.gas(amount);
    }

    /**
     * Makes the car decelerate, decreases its current speed.
     * @param amount amount to decrease the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void brake(double amount){
        vehicle.brake(amount);
    }

    /**
     * returns the number of doors on the vehicle
     * @return number of doors on the vehicle
     */
    public int getNrDoors(){
        return vehicle.getNrDoors();
    }

    /**
     * Returns the power of the vehicle's engine
     * @return vehicle's engine power
     */
    public double getEnginePower(){
        return vehicle.getEnginePower();
    }

    /**
     * Returns the name of the model of the vehicle
     * @return vehicle's model name
     */
    public String getModelName(){
        return vehicle.getModelName();
    }

    /**
     * Returns the vehicles color
     * @return vehicles' color
     */
    public Color getColor(){
        return vehicle.getColor();
    }

    /**
     * Returns the current total velocity of the car.
     * @return current velocity of the car
     */
    public double getCurrentSpeed(){
        return vehicle.getCurrentSpeed();
    }

    /**
     * Returns the position of the car.
     * @return a Point with x and y coordinates
     */
    public Point2D getPos() {
        return vehicle.getPos();
    }

    /**
     * Returns the current direction of the car's velocity in radians.
     * @return the car's velocity's direction in radians
     */
    public double getDirection() {
        return vehicle.getDirection();
    }

}
