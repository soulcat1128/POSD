package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ConvexPolygonTest {
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private ConvexPolygon convexPolygon;
    private List<TwoDimensionalVector> vectors = new ArrayList<>();

    @Before
    public void setUp() {
        vectors.add(new TwoDimensionalVector(1, 1));
        vectors.add(new TwoDimensionalVector(3, 1));
        vectors.add(new TwoDimensionalVector(3, 4));
        vectors.add(new TwoDimensionalVector(1, 4));
        convexPolygon = new ConvexPolygon(vectors);
    }

    @Test
    public void testConvexPolygonAreaCalculation() {
        assertEquals(convexPolygon.area(), 6.0, 0.01);
    }

    @Test
    public void testConvexPolygonPerimeterCalculation() {
        assertEquals(convexPolygon.perimeter(), 10.0, 0.01);
    }   

    @Test
    public void testConvexPolygonAdd()
    {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("Illegal Operation");
        convexPolygon.add(new Circle(1));
    }
    
    @Test
    public void testConvexPolygonIterator()
    {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Null iterator does not point to any element");
        assertTrue(convexPolygon.iterator() instanceof NullIterator);
        assertFalse(convexPolygon.iterator().hasNext());
        convexPolygon.iterator().next();
    }

    @Test
    public void testConvexPolygonWithCollinear() throws Exception {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a convex polygon!");
        vectors.clear();
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(6, 0));
        vectors.add(new TwoDimensionalVector(9, 0));
        new ConvexPolygon(vectors);
    }

    @Test
    public void testConvexPolygonCounterclockwise()
    {
        vectors.clear();
        vectors.add(new TwoDimensionalVector(1, 1));
        vectors.add(new TwoDimensionalVector(1, 4));
        vectors.add(new TwoDimensionalVector(3, 4));
        vectors.add(new TwoDimensionalVector(3, 1));
        convexPolygon = new ConvexPolygon(vectors);
        assertEquals(convexPolygon.area(), 6.0, 0.01);
        assertEquals(convexPolygon.perimeter(), 10.0, 0.01);
    }

    @Test
    public void testNotConvexPolygon()
    {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a convex polygon!");
        vectors.clear();
        vectors.add(new TwoDimensionalVector(1, 1));
        vectors.add(new TwoDimensionalVector(4, 1));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(1, 3));
        vectors.add(new TwoDimensionalVector(2, 2));
        new ConvexPolygon(vectors);
    }

}