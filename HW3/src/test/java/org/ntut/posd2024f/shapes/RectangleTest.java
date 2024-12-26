package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    private Rectangle r1, r2;

    @BeforeEach
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
        ShapeException exception = assertThrows(ShapeException.class, ()->{new Rectangle(-1, 5.0);});
        assertEquals(exception.getMessage(), "It's not a rectangle!");
    }

    @Test
    public void testRectangleWithZeroEdge() throws Exception
    {
        ShapeException exception = assertThrows(ShapeException.class, ()->{new Rectangle(0, 5.0);});
        assertEquals(exception.getMessage(), "It's not a rectangle!");
    }

    @Test
    public void testRectangleWithAdd() throws Exception
    {
        ShapeException exception = assertThrows(ShapeException.class, ()->{r1.add(r2);});
        assertEquals(exception.getMessage(), "Illegal Operation");
    }

    @Test
    public void testRectangleWithIterator()
    {
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, ()->{r1.iterator().next();});
        assertTrue(r1.iterator() instanceof NullIterator);
        assertFalse(r1.iterator().hasNext());
        assertEquals(exception.getMessage(), "Null iterator does not point to any element");
    }
}