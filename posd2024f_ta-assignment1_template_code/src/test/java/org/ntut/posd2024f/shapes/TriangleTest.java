package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TriangleTest {
    
    private Triangle t1, t2;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp()
    {
        try {
            t1 = new Triangle(1.0, 2.0, 2.5);
            t2 = new Triangle(3.5, 4.8, 4.9);
        } catch (Exception e) {
            fail("Triangle create fail");
        }
    }

    @Test
    public void testTriangleAreaCalculation()
    {   
        double side = 1.0 + 2.0 + 2.5;
        double s = side / 2;
        double expectedArea1 = Math.sqrt(s * (s - 1.0) * (s - 2.0) * (s - 2.5));

        assertEquals(expectedArea1, t1.area(), 0.01);
    }

    @Test
    public void testTrianglePerimeterCalculation()
    {
        double expectedPerimeter1 = 1.0 + 2.0 + 2.5;
        double expectedPerimeter2 = 3.5 + 4.8 + 4.9;
        
        assertEquals(expectedPerimeter1, t1.perimeter(), 0.01);
        assertEquals(expectedPerimeter2, t2.perimeter(), 0.01);    
    }

    @Test
    public void testTriangleWithInvalidEdge() throws Exception
    {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a triangle!");
        new Triangle(0, 0.9, 1.0);
    }

    @Test
    public void testTriangleToString()
    {
        assertEquals(t1.toString(), "Triangle 1.0 2.0 2.5");
        assertEquals(t2.toString(), "Triangle 3.5 4.8 4.9");
    }

    @After
    public void after()
    {
        t1 = null;
        t2 = null;
    }
}