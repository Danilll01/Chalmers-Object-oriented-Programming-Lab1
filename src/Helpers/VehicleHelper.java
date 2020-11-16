package Helpers;

import java.awt.*;

public class VehicleHelper
{
    /**
     * Number of doors on the car.
     */
    private final int nrDoors;
    /**
     * Color of the car.
     */
    private final Color color;
    /**
     * The cars modelname
     */
    private final String modelName;
    /**
     * Decides the max speed of the car as well as its rate of acceleration.
     */
    private final double enginePower;

    /**
     * Creates a new VehicleHelper with specified parameters.
     * @param doors nr of doors on the vehicle
     * @param color color of the vehicle
     * @param model model name of the vehicle
     * @param enginePower power of the vehicle's engine
     */
    public VehicleHelper(int doors, Color color, String model, double enginePower)
    {
        this.nrDoors = doors;
        this.color = color;
        this.modelName = model;
        this.enginePower = enginePower;
    }

    /**
     * returns the number of doors on the vehicle
     * @return number of doors on the vehicle
     */
    public int getNumberDoors(){
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

}
