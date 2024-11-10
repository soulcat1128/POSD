package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircleTest {
    private Circle c1, c2;
    
    @BeforeEach
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
        ShapeException exception = assertThrows(ShapeException.class, ()->{new Circle(-1);});
        assertEquals("It's not a circle!", exception.getMessage());
    }

    @Test
    public void testCircleWithZeroRadius() throws Exception
    {
        ShapeException exception = assertThrows(ShapeException.class, ()->{new Circle(0);});
        assertEquals("It's not a circle!", exception.getMessage());
    }

    @Test
    public void testCircleWithAdd() throws Exception
    {
        ShapeException exception = assertThrows(ShapeException.class, ()->{c1.add(c2);});
        assertEquals("Illegal Operation", exception.getMessage());
    }

    @Test
    public void testCircleWithIterator()
    {
        assertTrue(c1.iterator() instanceof NullIterator);
        assertFalse(c1.iterator().hasNext());
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, ()->{c1.iterator().next();});
        assertEquals(exception.getMessage(), "Null iterator does not point to any element");
    }

}