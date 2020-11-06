import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Volvo240Test {

    Volvo240 volvo;

    @Before
    public void before(){
        volvo = new Volvo240();
    }

    @Test
    public void color(){
        assertEquals(Color.BLACK, volvo.getColor());
    }

    @Test
    public void model(){
        assertEquals("Volvo 240", volvo.getModelName());
    }

    @Test
    public void doors(){
        assertEquals(4, volvo.getNrDoors());
    }

    @Test
    public void enginePower() {
        assertEquals(100, volvo.getEnginePower(), 0.001);
    }

    @Test
    public void gas(){
        double resultSpeed = volvo.getCurrentSpeed() + getSpeedFactor() * 10;

        volvo.gas(10);

        assertEquals(resultSpeed, volvo.getCurrentSpeed(), 0.001);
    }

    @Test
    public void brake(){
        volvo.brake(10);

        assertEquals(0, volvo.getCurrentSpeed(), 0.001);
    }

    private double getSpeedFactor() {
        return Volvo240.getTrimFactor() * 0.01 * volvo.getEnginePower();
    }

    @Test
    public void moveX(){
        volvo.gas(10);
        double firstX = volvo.getPosX();
        volvo.move();

        double result = firstX + volvo.getCurrentSpeed();

        assertEquals(result, volvo.getPosX(), 0.001);
    }

    @Test
    public void moveY(){
        volvo.gas(10);
        double firstY = volvo.getPosY();
        volvo.turnLeft();
        volvo.move();

        double result = firstY + volvo.getCurrentSpeed();

        assertEquals(result, volvo.getPosY(), 0.001);
    }


}
