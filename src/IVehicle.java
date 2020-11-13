/**
 * Interface for vehicle capable of stopping and starting movement, as well as acceleration/deceleration.
 */
public interface IVehicle {
    /**
     * Sets the speed of the vehicle to 0.1. Makes the vehicle start moving. Should be called when the vehicle isn't moving.
     */
    void startEngine();

    /**
     * Sets the speed of the vehicle to 0. Makes the vehicle stop moving.
     */
    void stopEngine();

    /**
     * Makes the vehicle accelerate, increases its current speed.
     * @param amount amount to increase the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    void gas(double amount);

    /**
     * Makes the vehicle decelerate, decreases its current speed.
     * @param amount amount to decrease the car's speed by (between 0 and 1)
     * @throws IllegalArgumentException if amount is not between 0 and 1
     */
    void brake(double amount);
}
