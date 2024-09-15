package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RectangleTest {

    private Rectangle r1, r2;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp()
    {
        try {
            r1 = new Rectangle(2.0, 3.5);
            r2 = new Rectangle(20.0, 8.4);
        } catch (Exception e) {
            fail("Rectangle create fail");
        }
    }

    @Test
    public void testRectangleAreaCalculation()
    {
        double expectedArea1 = 2.0 * 3.5;
        double expectedArea2 = 20.0 * 8.4; 

        assertEquals(expectedArea1, r1.area(), 0.01);
        assertEquals(expectedArea2, r2.area(), 0.01);
    }
    
    @Test
    public void testRectanglePerimeterCalculation()
    {
        double expectedPerimeter1 = (2 * 2.0) + (2 * 3.5);
        double expectedPerimeter2 = (2 * 20.0) + (2 * 8.4);

        assertEquals(expectedPerimeter1, r1.perimeter(), 0.01);
        assertEquals(expectedPerimeter2, r2.perimeter(), 0.01);
    }

    @Test
    public void testRectangleWithInvalidEdge() throws Exception
    {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a rectangle!");
        new Rectangle(-1, 5.0);
    }

    @Test
    public void testRectangleWithZeroEdge() throws Exception
    {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a rectangle!");
        new Rectangle(0, 5.0);
    }

    @Test
    public void testRectangleToString()
    {
        assertEquals("Rectangle 2.0 3.5", r1.toString());
        assertEquals("Rectangle 20.0 8.4", r2.toString());
    }

    @After
    public void after()
    {
        r1 = null;
        r2 = null;
    }

}