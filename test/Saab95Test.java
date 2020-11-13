import org.junit.Before;
import org.junit.Test;
import java.awt.*;

import static org.junit.Assert.*;

public class Saab95Test {

    Saab95 saab;

    @Before
    public void before(){
        saab = new Saab95();
    }

    @Test
    public void doors(){
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    public void enginePower() {
        assertEquals(125, saab.getEnginePower(), 0.001);
    }

    @Test
    public void engineStart(){
        saab.startEngine();
        assertTrue(saab.getCurrentSpeed() > 0);
    }

    @Test
    public void isTurboOff() {
        saab.setTurboOff();
        assertFalse(saab.isTurboOn());
    }

    @Test
    public void isTurboOn() {
        saab.setTurboOn();
        assertTrue(saab.isTurboOn());
    }

    @Test
    public void gas(){
        double resultSpeed = saab.getCurrentSpeed() + getSpeedFactor() * 0.5;

        saab.gas(0.5);

        assertEquals(resultSpeed, saab.getCurrentSpeed(), 0.001);
    }

    @Test
    public void brake(){
        double resultSpeed = 0;

        saab.brake(0.5);

        assertEquals(resultSpeed, saab.getCurrentSpeed(), 0.001);
    }

    private double getSpeedFactor() {
        double turbo = saab.isTurboOn() ? 1.3 : 1;
        return turbo * 0.01 * saab.getEnginePower();
    }

    @Test
    public void moveX(){
        saab.gas(0.5);
        double firstX = saab.getPos().getX();
        saab.move();

        double result = firstX + saab.getCurrentSpeed();

        assertEquals(result, saab.getPos().getX(), 0.001);
    }

    @Test
    public void moveY(){
        saab.gas(0.5);
        double firstY = saab.getPos().getY();
        saab.turnLeft();
        saab.move();

        double result = firstY + saab.getCurrentSpeed();

        assertEquals(result, saab.getPos().getY(), 0.001);
    }

    @Test
    public void leftTurn(){
        saab.turnLeft();
        assertEquals(Math.PI / 2, saab.getDirection(), 0.001);
    }

    @Test
    public void rightTurn(){
        saab.turnRight();
        assertEquals(-Math.PI / 2, saab.getDirection(), 0.001);
    }


}
