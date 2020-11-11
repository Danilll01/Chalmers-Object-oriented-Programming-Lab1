import java.awt.*;


/**
 *
 */
public abstract class Car implements Movable
{
    private int nrDoors; // number of doors on the car
    private Color color;
    private double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private String modelName; // The car model name

    private double posX;
    private double posY;
    private double direction; // direction of velocity in radians

    protected void setModelName(String modelName) {
        this.modelName = modelName;
    }

    protected void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    protected void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    // TEMPORARY
    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getDirection() {
        return direction;
    }


    protected abstract double speedFactor();

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

    public void move(){
        posX += getCurrentSpeed() * Math.cos(direction);
        posY += getCurrentSpeed() * Math.sin(direction);
    }
    // turns left 90 degrees, or 1/2 PI
    public void turnLeft(){
        direction += Math.PI / 2;
    }
    // turns right 90 degrees, or 1/2 PI
    public void turnRight(){
        direction -= Math.PI / 2;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }


}
