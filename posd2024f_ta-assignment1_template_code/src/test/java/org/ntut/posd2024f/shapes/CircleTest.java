package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CircleTest {

    private Circle c1, c2;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp()
    {
        try {
            c1 = new Circle(5.0);
            c2 = new Circle(2.0);
        } catch (Exception e) {
            fail("Circle Create fail");
        }
    }
    
    @Test
    public void testCircleAreaCalculation()
    {
        double expectedArea1 = Math.PI * 5.0 * 5.0;
        double expectedArea2 = Math.PI * 2.0 * 2.0;

        assertEquals(expectedArea1, c1.area(), 0.01);
        assertEquals(expectedArea2 , c2.area(), 0.01);
    }

    @Test
    public void testCirclePerimeterCalculation()
    {
        double expectedPerimeter1 = 2 * Math.PI * 5.0;
        double expectedPerimeter2 = 2 * Math.PI * 2.0;

        assertEquals(expectedPerimeter1, c1.perimeter(), 0.01);
        assertEquals(expectedPerimeter2, c2.perimeter(), 0.01);
    }

    @Test
    public void testCircleWithInvalidRadius() throws Exception
    {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a circle!");
        new Circle(-1);
    }

    @Test
    public void testCircleWithZeroRadius() throws Exception
    {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a circle!");
        new Circle(0);
    }

    @Test
    public void testCircleToString()
    {
        assertEquals(c1.toString(), "Circle 5.0");
        assertEquals(c2.toString(), "Circle 2.0");
    }

    @After
    public void after()
    {
        c1 = null;
        c2 = null;
    }
}