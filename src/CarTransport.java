import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Represents the idea of a truck that can load and transport cars
 * Has a ramp that can be either lowered(cars loadable) or raised(cars not loadable) and attributes like number of doors, color, enginepower, moodelname, position and a deque for storing cars
 */
public class CarTransport implements IVehicle, Movable {

    /**
     * Truck delegate object.
     */
    private final Truck truck;

    /**
     * True if the ramp of the car transporter is lowered.
     */
    private boolean rampLowered;
    /**
     * Stack of stored cars on the transporter.
     */
    private final Deque<Car> storedCars;

    /**
     * Sets car transport attributes to default values.
     */
    public CarTransport() {
        this.truck = new Truck(2, Color.GREEN, 220, "Car Transporter", 0, 0);
        storedCars = new ArrayDeque<>(3);
        rampLowered = false;
    }

    /**
     * Returns the factor by which the speed should be modified when it accelerates/decelerates.
     *
     * @return factor to modify currentSpeed with during acceleration/deceleration
     */
    private double speedFactor() {
        return truck.getEnginePower() * 0.02;
    }

    /**
     * Sets the speed of the vehicle to 0.1. Makes the vehicle start moving.
     */
    public void startEngine() {
        truck.startEngine();
        for(Car car : storedCars) car.startEngine();
    }

    /**
     * Sets the speed of the vehicle to 0. Makes the vehicle stop moving.
     */
    public void stopEngine() {
        truck.stopEngine();
        for(Car car : storedCars) car.stopEngine();
    }

    /**
     * Makes the vehicle accelerate, increases its current speed.
     *
     * @param amount amount to increase the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void gas(double amount) {
        truck.gas(amount);
        for(Car car : storedCars) car.gas(amount);
    }

    /**
     * Makes the vehicle decelerate, decreases its current speed.
     *
     * @param amount amount to decrease the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    public void brake(double amount) {
        truck.brake(amount);
        for(Car car : storedCars) car.brake(amount);
    }

    /**
     * Moves the object.
     */
    public void move() {
        if(!rampLowered) {
            truck.move();
        }
    }

    /**
     * Makes the object turn left.
     */
    public void turnLeft() {
        truck.turnLeft();
        for(Car car : storedCars) car.turnLeft();
    }

    /**
     * Makes the object turn right.
     */
    public void turnRight() {
        truck.turnRight();
        for(Car car : storedCars) car.turnRight();
    }

    /**
     * Raises the angle of the truck's platform, but only if the truck is stationary.
     * If the truck is moving, then the platform will not raise itself.
     */
    public void raiseRamp() {
        rampLowered = false;
    }

    /**
     * Lowers the angle of the truck's platform, but only if the truck is stationary.
     * If the truck is moving, then the platform will not lower itself.
     */
    public void lowerRamp() {
        if(truck.getCurrentSpeed() < 0.001) rampLowered = true;
    }

    /**
     * Loads given car into the storedCars Deque. Car must be within a distance of 5 of the car transport, and the car
     * transport cannot have 3 or more cars on it already.
     * @param car car to be loaded into the car transport
     */
    public void loadCar(Car car){
        if(storedCars.size() >= 3 || !rampLowered) return;
        Point2D.Double current = truck.getPos();
        Point2D.Double carPos = car.getPos();

        double distX = Math.abs(current.getX() - carPos.getX());
        double distY = Math.abs(current.getY() - carPos.getY());

        double distance = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));

        if(distance > 5) return;

        car.loadCar(this);
        storedCars.add(car);
    }

    /**
     * Unloads last car from transport unless transport is empty.
     */
    public void unloadCar(){
        if(storedCars.isEmpty() || !rampLowered) return;

        storedCars.pop().unloadCar();
    }

    /**
     * Returns the position of the car transporter.
     * @return a Point with x and y coordinates
     */
    public Point2D.Double getPos() {
        return truck.getPos();
    }

    /**
     * Gets the truck's current speed
     * @return current speed
     */
    public double getCurrentSpeed(){
        return truck.getCurrentSpeed();
    }

    /**
     * Gets the trucks current direction
     * @return direction
     */
    public double getDirection() {
        return truck.getDirection();
    }
}
