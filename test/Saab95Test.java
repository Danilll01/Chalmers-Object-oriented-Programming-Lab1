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
    public void color(){
        assertEquals(Color.RED, saab.getColor());
    }

    @Test
    public void model(){
        assertEquals("Saab 95", saab.getModelName());
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
        double resultSpeed = saab.getCurrentSpeed() + getSpeedFactor() * 10;

        saab.gas(10);

        assertEquals(resultSpeed, saab.getCurrentSpeed(), 0.001);
    }

    @Test
    public void brake(){
        double resultSpeed = saab.getCurrentSpeed() - getSpeedFactor() * 10;

        saab.brake(10);

        assertEquals(resultSpeed, saab.getCurrentSpeed(), 0.001);
    }

    private double getSpeedFactor() {
        double turbo = saab.isTurboOn() ? 1.3 : 1;
        return turbo * 0.01 * saab.getEnginePower();
    }

    @Test
    public void moveX(){
        saab.gas(10);
        double firstX = saab.getPosX();
        saab.move();

        double result = firstX + saab.getCurrentSpeed();

        assertEquals(result, saab.getPosX(), 0.001);
    }

    public void moveY(){
        saab.gas(10);
        double firstY = saab.getPosY();
        saab.turnLeft();
        saab.move();

        double result = firstY + saab.getCurrentSpeed();

        assertEquals(result, saab.getPosY(), 0.001);
    }


}
