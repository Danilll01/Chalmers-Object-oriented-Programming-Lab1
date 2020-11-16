package Helpers;

import java.awt.geom.Point2D;

/**
 * Keeps track of a vehicles position, speed and direction
 */
public class PositionHelper {
    /**
     * Current total velocity of the car.
     */
    private double currentSpeed;
    /**
     * The cars position described with a Point2D.Double object.
     */
    private Point2D.Double position;
    /**
     * The direction of the cars velocity in radians
     */
    private double direction;

    /**
     * Creates a new PositionHelper with specified parameters.
     * @param currentSpeed current speed of vehicle
     * @param x x position of vehicle
     * @param y y position of vehicle
     * @param direction vehicles direction in radians
     */
    public PositionHelper(double currentSpeed, double x, double y, double direction) {
        this.currentSpeed = currentSpeed;
        this.position = new Point2D.Double(x,y);
        this.direction = direction;
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
     * Sets the speed of the vehicle to specified value
     * @param speed specified speed to be set
     */
    public void setCurrentSpeed(double speed){
        currentSpeed = speed;
    }

    /**
     * Sets position of the vehicle to specified values along x- and y-axis.
     * @param x new position along x-axis
     * @param y new position along y-axis
     */
    public void setPosition(double x, double y){
        position.setLocation(x, y);
    }

    /**
     * Sets the direction of the vehicle to specified angle
     * @param direction new direction of the vehicle in radians.
     */
    public void setDirection(double direction){
        this.direction = direction;
    }
}
