import Helpers.VehicleHelper;

import java.awt.*;

/**
 * Implements the idea of a truck, has a ramp that can be lowered
 */
public class Truck implements IVehicle, Movable
{

    private final VehicleHelper vHelper;

    public Truck() {
        this.vHelper = new VehicleHelper(2, Color.PINK, "Scania-R", 200, 0 ,0 );
    }

    /**
     * Sets the speed of the vehicle to 0.1. Makes the vehicle start moving. Should be called when the vehicle isn't moving.
     */
    public void startEngine() {

    }

    /**
     * Sets the speed of the vehicle to 0. Makes the vehicle stop moving.
     */
    public void stopEngine() {

    }

    /**
     * Makes the vehicle accelerate, increases its current speed.
     *
     * @param amount amount to increase the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void gas(double amount) {

    }

    /**
     * Makes the vehicle decelerate, decreases its current speed.
     *
     * @param amount amount to decrease the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void brake(double amount) {

    }

    /**
     * Moves the object.
     */
    public void move() {

    }

    /**
     * Makes the object turn left.
     */
    public void turnLeft() {

    }

    /**
     * Makes te object turn right.
     */
    public void turnRight() {

    }
}
