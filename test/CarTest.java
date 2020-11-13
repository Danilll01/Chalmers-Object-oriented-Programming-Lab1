import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

import static org.junit.Assert.*;

public class CarTest {

    Car car;

    @Before
    public void before(){
        car = new Car(0,0, 3, Color.MAGENTA, 189, "TEST CAR");
    }

    @Test
    public void initialSpeedZero(){
        assertEquals(0, car.getCurrentSpeed(), 0.001);
    }

    @Test
    public void initDirection(){
        assertEquals(0, car.getDirection(), 0.001);
    }

    @Test
    public void ExceptionTestGas(){
        boolean correctException = false;
        try {
            car.gas(-1);
        } catch (IllegalArgumentException e){
            correctException = true;
        }

        assertTrue(correctException);
    }

    @Test
    public void ExceptionTestBrake(){
        boolean correctException = false;
        try {
            car.brake(-1);
        } catch (IllegalArgumentException e){
            correctException = true;
        }

        assertTrue(correctException);
    }
}
