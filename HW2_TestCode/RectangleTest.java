package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
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
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a rectangle!");
        new Rectangle(-1, 5.0);
    }

    @Test
    public void testRectangleWithZeroEdge() throws Exception
    {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a rectangle!");
        new Rectangle(0, 5.0);
    }

    @Test
    public void testRectangleWithAdd() throws Exception
    {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("Illegal Operation");
        r1.add(r2);
    }

    @Test
    public void testRectangleWithIterator()
    {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Null iterator does not point to any element");

        assertTrue(r1.iterator() instanceof NullIterator);
        assertFalse(r1.iterator().hasNext());
        r1.iterator().next(); 
    }
}