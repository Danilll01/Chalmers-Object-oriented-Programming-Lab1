import java.awt.*;

/**
 * Implements the idea of a Scania truck
 * Has a ramp that can be raised or lowered when this truck is stationary
 */
public class Scania extends Truck {

    /**
     * Variable for the angle of the ramp
     */
    private int platformAngle;

    /**
     * Sets the attributes to their default values
     */
    public Scania(){
        super(Color.PINK, "Scania-R", 2, 200, 0, 0);
    }

    /**
     * Passes constructor parameters to super.
     */
    public Scania(Color color, String modelName, int nDoors, double enginePower, double posX, double posY) {
        super(color, modelName, nDoors, enginePower, posX, posY);
    }

    /**
     * Raises the angle of the truck's platform by specified amount of degrees but only if the truck is stationary.
     * If the truck is moving, then the platform will not raise itself.
     *
     * @param amount angle in degrees
     */
    public void raisePlatform(int amount) {
        if (amount < 0 || getCurrentSpeed() > 0.001) return;
        int newValue = platformAngle + amount;

        platformAngle = Math.min(newValue, 70);
    }

    /**
     * Lowers the angle of the truck's platform by specified amount of degrees,  but only if the truck is stationary.
     * If the truck is moving, then the platform will not lower itself.
     *
     * @param amount angle in degrees
     */
    public void lowerPlatform(int amount) {
        if (amount < 0 || getCurrentSpeed() > 0.001) return;
        int newValue = platformAngle - amount;

        platformAngle = Math.max(newValue, 0);
    }
    /**
     * Getter for platformAngle, used for tests
     * @return returns the platforms angle
     */
    public int getplatformAngle() {
        return platformAngle;
    }
    /**
     * Returns the factor by which the speed should be modified when it accelerates/decelerates.
     * @return factor to modify currentSpeed with during acceleration/deceleration
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
