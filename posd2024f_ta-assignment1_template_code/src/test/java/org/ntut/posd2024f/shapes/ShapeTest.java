package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ShapeTest {
    
    @Test
    public void testCircle() throws Exception
    {
        Circle c = new Circle(5.0);
        assertEquals(Math.PI * 5.0 * 5.0, c.area(), 0.01);
        assertEquals(2 * Math.PI * 5.0, c.perimeter(), 0.01);
        assertEquals("Circle 5.0", c.toString());
    }

    @Test
    public void testTriangle() throws Exception
    {
        Triangle t = new Triangle(3.0, 4.0, 5.0);
        double side = 3.0 + 4.0 + 5.0;
        double s = side / 2;
        double expectedArea =  Math.sqrt(s * (s - 3.0) * (s - 4.0) * (s - 5.0));

        assertEquals(expectedArea, t.area(), 0.01);
        assertEquals(side, t.perimeter(), 0.01);
        assertEquals("Triangle 3.0 4.0 5.0", t.toString());
    }

    @Test
    public void testRectangle() throws Exception
    {
        Rectangle r = new Rectangle(4.0, 5.0);
        
        assertEquals(20.0, r.area(), 0.01);
        assertEquals(18.0, r.perimeter(), 0.01);
        assertEquals("Rectangle 4.0 5.0", r.toString());
    }

}