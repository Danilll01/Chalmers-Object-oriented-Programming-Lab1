import java.awt.*;

/**
 * Implemented model of the Car superclass. Implements a trim feature.
 */
public class Volvo240 extends Car {

    /**
     * Modifies the rate at which the car accelerates/decelerates.
     */
    private final static double trimFactor = 1.25;

    /**
     * Sets this cars color to black, model name to "Volvo 240", number of doors to 4, engine power to 100, stops the engine and sets start position to 0,0.
     */
    public Volvo240(){
        setColor(Color.BLACK);
        setModelName("Volvo 240");
        setNrDoors(4);
        setEnginePower(100);
        stopEngine();

        setPos(0, 0);
    }

    /**
     * Returns the car trim factor of the car.
     * @return volvo's trim factor
     */
    public static double getTrimFactor() {
        return trimFactor;
    }

    /**
     * Returns the factor by which the speed should be modified when it accelerates/decelerates. Affected by the car's
     * trim factor.
     * @return factor to modify currentSpeed with during acceleration/deceleration
     */
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    protected void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    @Override
    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}
