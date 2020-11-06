import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {

    Saab95 saab;

    @Before
    public void before(){
        saab = new Saab95();
    }

    @Test
    public void initialSpeedZero(){
        assertEquals(0, saab.getCurrentSpeed(), 0.001);
    }

    @Test
    public void engineStart(){
        saab.startEngine();
        assert(saab.getCurrentSpeed() > 0);
    }

    @Test
    public void initDirection(){
        assertEquals(0, saab.getDirection(), 0.001);
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
