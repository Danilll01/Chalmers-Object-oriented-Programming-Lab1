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
     * Delegate vehicle object.
     */
    private final Vehicle vehicle;

    /**
     * Transporter on which the car is loaded onto.
     */
    private CarTransport transport;
    /**
     * True if the car is on a car transporter.
     */
    private boolean loaded;

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
     * Updates the car's position in the 2D plane according to it's currentSpeed and direction. Simply sets position
     * to transporters position if the car is on a transporter.
     */
    public void move(){
        if(loaded){
            Point2D.Double newPos = transport.getPos();
            vehicle.setPosition(newPos.getX(), newPos.getY());
        }
        else vehicle.move();
    }

    /**
     * Makes the car turn 90 degrees to the left. Increases the car's direction by PI/2 radians. Sets direction to transporters
     * direction if the car is on a transporter.
     */
    public void turnLeft(){
        if(!loaded) vehicle.turnLeft();
        else vehicle.setDirection(transport.getDirection());
    }

    /**
     * Makes the car turn 90 degrees to the right. Decreases the car's direction by PI/2 radians. Sets direction to transporters
     *      * direction if the car is on a transporter.
     */
    public void turnRight(){
        if(!loaded) vehicle.turnRight();
        else vehicle.setDirection(transport.getDirection());
    }

    /**
     * Sets the current speed of the car to 0. Makes the car stop moving. Sets speed to transporters
     * speed if the car is on a transporter.
     */
    public void stopEngine() {
        if(!loaded) vehicle.stopEngine();
        else vehicle.setCurrentSpeed(transport.getCurrentSpeed());
    }

    /**
     * Sets the current speed of the car to 0.1. Make the car start moving. Should be called when the car isn't moving. Sets speed to transporters
     * speed if the car is on a transporter.
     */
    public void startEngine() {
        if(!loaded) vehicle.startEngine();
        else vehicle.setCurrentSpeed(transport.getCurrentSpeed());
    }

    /**
     * Makes the car accelerate, increases its current speed. Sets speed to transporters
     * speed if the car is on a transporter.
     * @param amount amount to increase the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void gas(double amount){
        if(!loaded)vehicle.gas(amount);
        else vehicle.setCurrentSpeed(transport.getCurrentSpeed());
    }

    /**
     * Makes the car decelerate, decreases its current speed. Sets speed to transporters
     * speed if the car is on a transporter.
     * @param amount amount to decrease the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void brake(double amount){
        if(!loaded) vehicle.brake(amount);
        else vehicle.setCurrentSpeed(transport.getCurrentSpeed());
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
    public Point2D.Double getPos() {
        return vehicle.getPos();
    }

    /**
     * Returns the current direction of the car's velocity in radians.
     * @return the car's velocity's direction in radians
     */
    public double getDirection() {
        return vehicle.getDirection();
    }

    /**
     * Method that is called when the car gets loaded onto a car transporter. Sets relevant attributes to specified values
     * to keep track of the transporter's speed and other attributes in the future.
     * @param transport car transporter that the car is loaded onto
     */
    public void loadCar(CarTransport transport){
        this.transport = transport;
        loaded = true;

        Point2D.Double currentPos = transport.getPos();

        vehicle.setPosition(currentPos.getX(), currentPos.getY());
        vehicle.setCurrentSpeed(0);
        vehicle.setDirection(transport.getDirection());
    }

    /**
     * Method to be called when the car gets unloaded from a car transporter.
     */
    public void unloadCar(){
        this.transport = null;
        loaded = false;

        Point2D.Double currentPos = vehicle.getPos();

        vehicle.setPosition(currentPos.getX() + 5, currentPos.getY() + 5);
    }

}
