import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Helps vehicle classes with handling several parameters, such as number of doors,
 * color, model name, engine power, velocity, position and direction; as well as
 * handling these in different ways.
 *
 * Used to avoid code duplication.
 */
public class Vehicle implements IVehicle
{
    /**
     * Number of doors on the vehicle.
     */
    private final int nrDoors;
    /**
     * Color of the vehicle.
     */
    private final Color color;
    /**
     * The vehicle's model name
     */
    private final String modelName;
    /**
     * Decides the max speed of the vehicle as well as its rate of acceleration.
     */
    private final double enginePower;

    /**
     * Current total velocity of the vehicle.
     */
    private double currentSpeed;
    /**
     * The vehicle's position described with a Point2D.Double object.
     */
    private final Point2D.Double position;
    /**
     * The direction of the vehicle's velocity in radians
     */
    private double direction;

    /**
     * Creates a new VehicleHelper with specified parameters.
     * @param doors nr of doors on the vehicle
     * @param color color of the vehicle
     * @param model model name of the vehicle
     * @param enginePower power of the vehicle's engine
     */
    public Vehicle(int doors, Color color, String model, double enginePower, double posX, double posY)
    {
        this.nrDoors = doors;
        this.color = color;
        this.modelName = model;
        this.enginePower = enginePower;

        this.currentSpeed = 0;
        this.direction = 0;
        this.position = new Point2D.Double(posX, posY);

    }

    /**
     * returns the number of doors on the vehicle
     * @return number of doors on the vehicle
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns the power of the vehicle's engine
     * @return vehicle's engine power
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Returns the name of the model of the vehicle
     * @return vehicle's model name
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * Returns the vehicles color
     * @return vehicles' color
     */
    public Color getColor(){
        return color;
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
    public Point2D.Double getPos() {
        return position;
    }

    public void setPosition(double x, double y){
        position.setLocation(x, y);
    }

    public void setDirection(double angle){
        direction = angle;
    }

    /**
     * Returns the current direction of the car's velocity in radians.
     * @return the car's velocity's direction in radians
     */
    public double getDirection() {
        return direction;
    }

    /**
     * Sets the speed of the vehicle to specified value
     * @param speed specified speed to be set
     */
    public void setCurrentSpeed(double speed){
        currentSpeed = speed;
    }

    /**
     * Increases current speed with specified amount
     * @param amount amount to increment speed by
     */
    public void incrementSpeed(double amount){
        currentSpeed += Math.min(currentSpeed + amount, enginePower);
    }

    /**
     * Decreases current speed with specified amount
     * @param amount amount decrement speed by
     */
    public void decrementSpeed(double amount){
        currentSpeed += Math.max(currentSpeed - amount, 0);
    }

    /**
     * Updates the vehicle's position in the 2D plane according to it's currentSpeed and direction.
     */
    public void move(){
        double x = currentSpeed * Math.cos(direction);
        double y = currentSpeed * Math.sin(direction);
        position.setLocation(position.getX() + x, position.getY() + y);
    }

    /**
     * Makes the vehicle turn 90 degrees to the left. Increases the vehicle's direction by PI/2 radians.
     */
    public void turnLeft(){
        direction = direction + Math.PI / 2;
    }

    /**
     * Makes the vehicle turn 90 degrees to the right. Decreases the vehicle's direction by PI/2 radians.
     */
    public void turnRight(){
        direction = direction - Math.PI / 2;
    }

    /**
     * Sets the speed of the vehicle to 0.1. Makes the vehicle start moving. Should be called when the vehicle isn't moving.
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Sets the speed of the vehicle to 0. Makes the vehicle stop moving.
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Makes the vehicle accelerate, increases its current speed.
     *
     * @param amount amount to increase the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void gas(double amount) {
        if(amount >= 1 || amount < 0) throw new IllegalArgumentException("gas amount has to be between 0 and 1");

        incrementSpeed(amount);
    }

    /**
     * Makes the vehicle decelerate, decreases its current speed.
     *
     * @param amount amount to decrease the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void brake(double amount) {
        if(amount >= 1 || amount < 0) throw new IllegalArgumentException("break amount has to be between 0 and 1");

        decrementSpeed(amount);
    }
}
