import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Implements the idea of a truck, has a ramp that can be lowered
 */
public class Truck implements IVehicle, Movable
{

    private final Vehicle vehicle;

    public Truck(int nrDoors, Color color, double enginePower, String modelName, double posX, double posY) {
        this.vehicle = new Vehicle(nrDoors, color, modelName, enginePower, posX ,posY );
    }

    /**
     * Sets the speed of the vehicle to 0.1. Makes the vehicle start moving. Should be called when the vehicle isn't moving.
     */
    public void startEngine() {
        vehicle.startEngine();
    }

    /**
     * Sets the speed of the vehicle to 0. Makes the vehicle stop moving.
     */
    public void stopEngine() {
        vehicle.stopEngine();
    }

    /**
     * Makes the vehicle accelerate, increases its current speed.
     *
     * @param amount amount to increase the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void gas(double amount) {
        vehicle.gas(amount);
    }

    /**
     * Makes the vehicle decelerate, decreases its current speed.
     *
     * @param amount amount to decrease the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void brake(double amount) {
        vehicle.brake(amount);
    }

    /**
     * Updates the truck's position in the 2D plane according to it's currentSpeed and direction.
     */
    public void move() {
        vehicle.move();
    }

    /**
     * Makes the truck turn 90 degrees to the left. Increases the truck's direction by PI/2 radians.
     */
    public void turnLeft() {
        vehicle.turnLeft();
    }

    /**
     * Makes the truck turn 90 degrees to the left. Increases the truck's direction by PI/2 radians.
     */
    public void turnRight() {
        vehicle.turnRight();
    }


    public double getEnginePower(){
        return vehicle.getEnginePower();
    }

    public double getCurrentSpeed(){ return vehicle.getCurrentSpeed(); }

    public Point2D.Double getPos() {
        return vehicle.getPos();
    }

    public double getDirection() {
        return vehicle.getDirection();
    }
}
