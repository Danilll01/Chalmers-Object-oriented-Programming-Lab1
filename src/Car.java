import java.awt.*;
import java.awt.geom.Point2D;


/**
 * Collection of attributes and functionality of a car, with a position in a 2D space and a direction (angle).
 *
 * Attributes consist of amount of doors, color, engine power, current speed, model name, x position, y, position and direction angle in radians.
 */
public abstract class Car implements Movable
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
    protected double currentSpeed;
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
     * Sets the name of the car's model.
     * @param modelName specified model name
     */
    protected void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * Sets the number of doors on the car.
     * @param nrDoors amount of doors
     */
    protected void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
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
     * Sets the engine power of the car.
     * @param enginePower specifiec engine power to be set
     */
    protected void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * Returns the current total velocity of the car.
     * @return current velocity of the car
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Sets the color of the car
     * @param clr color of the car
     */
    protected void setColor(Color clr){
        color = clr;
    }

    /**
     * Sets the currentSpeed to 0.1. Used to change the currentSpeed from 0.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets the current speed of the car to 0. Makes the car stop moving.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Returns the position of the car.
     * @return a Point with x and y coordinates
     */
    public Point2D getPos() {
        return position;
    }

    /**
     * Sets the position of the car in the 2D plane.
     * @param x car's position in x direction
     * @param y car's position in y direction
     */
    public void setPos(double x, double y) {
        position = new Point2D.Double(x,y);
    }

    /**
     * Returns the current direction of the car's velocity in radians.
     * @return the car's velocity's direction in radians
     */
    public double getDirection() {
        return direction;
    }

    /**
     * Returns the factor by which the speed should be modified when it accelerates/decelerates.
     * @return factor to modify currentSpeed with during acceleration/deceleration
     */
    protected abstract double speedFactor();

    /**
     * Increases the car's total velocity.
     * @param amount amount to increase the car's velocity by
     */
    protected abstract void incrementSpeed(double amount);

    /**
     * Decreases the car's total velocity.
     * @param amount amount to decrease the car's velocity by
     */
    protected abstract void decrementSpeed(double amount);

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
     * Makes the car accelerate, increases its current speed.
     * @param amount amount to increase the car's speed by
     */
    public void gas(double amount){

        incrementSpeed(amount);
    }

    /**
     * Makes the car decelerate, decreases its current speed.
     * @param amount amount to decrease the car's speed by
     */
    public void brake(double amount){
        decrementSpeed(amount);
    }


}
