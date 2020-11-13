import java.awt.*;
import java.awt.geom.Point2D;


/**
 * Collection of attributes and functionality of a car, with a position in a 2D space and a direction (angle).
 *
 * Attributes consist of amount of doors, color, engine power, current speed, model name, x position, y, position and direction angle in radians.
 */
public class Car implements Movable, IVehicle
{

    /**
     * Number of doors on the car.
     */
    private int nrDoors;
    /**
     * Color of the car.
     */
    private Color color;
    /**
     * Decides the max speed of the car as well as its rate of acceleration.
     */
    private double enginePower;
    /**
     * Current total velocity of the car.
     */
    private double currentSpeed;
    /**
     * Name of the car's model.
     */
    private String modelName;

    /**
     * The cars position described with a Point2D.Double object.
     */
    private Point2D.Double position;

    /**
     * The direction of the cars velocity in radians
     */
    private double direction;

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
        this.position = new Point2D.Double(posX, posY);
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.modelName = modelName;
        this.direction = 0;
    }

    /**
     * Returns the number of doors on the car.
     * @return the number of doors on the car
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns the engine power of the car.
     * @return the engine power of the car
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Returns the current total velocity of the car.
     * @return current velocity of the car
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Returns the position of the car.
     * @return a Point with x and y coordinates
     */
    public Point2D getPos() {
        return position;
    }

    /**
     * Returns the current direction of the car's velocity in radians.
     * @return the car's velocity's direction in radians
     */
    public double getDirection() {
        return direction;
    }

    /**
     * Increases the car's total velocity. Velocity cannot be increased beyond enginePower.
     * @param amount amount to increase the car's velocity by
     */
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + amount, getEnginePower());
    }

    /**
     * Decreases the car's total velocity. Velocity cannot be decreased to below zero.
     * @param amount amount to decrease the car's velocity by
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - amount, 0);
    }

    /**
     * Updates the car's position in the 2D plane according to it's currentSpeed and direction.
     */
    public void move(){
        double x = getCurrentSpeed() * Math.cos(direction);
        double y = getCurrentSpeed() * Math.sin(direction);
        position.setLocation(position.getX() + x, position.getY() + y);
    }

    /**
     * Makes the car turn 90 degrees to the left. Increases the car's direction by PI/2 radians.
     */
    public void turnLeft(){
        direction += Math.PI / 2;
    }

    /**
     * Makes the car turn 90 degrees to the right. Decreases the car's direction by PI/2 radians.
     */
    public void turnRight(){
        direction -= Math.PI / 2;
    }

    /**
     * Sets the current speed of the car to 0. Makes the car stop moving.
     */
    public void stopEngine() { currentSpeed = 0; }

    /**
     * Sets the current speed of the car to 0.1. Make the car start moving. Should be called when the car isn't moving.
     */
    public void startEngine() { currentSpeed = 0.1; }

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
