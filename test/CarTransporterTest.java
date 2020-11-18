import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTransporterTest {

    CarTransport transport;

    Car volvo;

    @Before
    public void before(){
        transport = new CarTransport();
        //volvo = new Volvo240(1.25);
    }

    @Test
    public void loadCar() {
        transport.loadCar(volvo);
    }

    @Test
    public void unloadCar(){
        transport.unloadCar();
        transport.gas(1);
        transport.move();
        volvo.move();

        assertEquals(0, transport.getCurrentSpeed() - volvo.getCurrentSpeed(), 0.01);
    }

}
