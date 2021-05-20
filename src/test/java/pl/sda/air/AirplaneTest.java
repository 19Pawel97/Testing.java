package pl.sda.air;

import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.standard.MediaSize;

import static org.junit.Assert.*;
public class AirplaneTest {
    private Airplane airplane;

    @Before
    public void Airplane() {
        airplane = new Airplane("Boeing 737",5000);
    }

    @Test
    public void testAscent() {
        // when
        airplane.ascent(1000);

        // then
        assertEquals(6000, airplane.getHeight(),0);
    }

    @Test
    public void testDescent() {
        // when
        airplane.descent(1000);

        // then
        assertEquals(4000, airplane.getHeight(),0);
    }

    @Test
    public void testTestGetName() {
        // when
        String name = airplane.getName();

        // then
        assertEquals("Boeing 737", name);
    }

    @Test
    public void testGetHeight() {
        // when
        int height = airplane.getHeight();

        // then
        assertEquals(5000, height,0);
    }
}