import java.awt.*;

/**
 * Implemented model of the Car superclass. Implements a turbo feature.
 */
public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Sets the car's color to red, model name to "Saab 95", number of doors to 2, engine power to 125,
     * position to (0, 0) and stops the engine (sets current speed to 0).
     */
    public Saab95(){
        setColor(Color.RED);
        setModelName("Saab 95");
        setNrDoors(2);
        setEnginePower(125);
        stopEngine();

        setPos(0, 0);
    }

    /**
     * Returns true if turbo is on.
     * @return state of the car's turbo
     */
    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     * Turns on the car's turbo feature.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns off the car's turbo feature.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Returns the factor by which the speed should be modified when it accelerates/decelerates. Affected by the state
     * of the car's turbo.
     * @return factor to modify currentSpeed with during acceleration/deceleration
     */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
