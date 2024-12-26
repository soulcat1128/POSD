package org.ntut.posd2024f.shapes;

<<<<<<< HEAD
public class ConvexPolygonTest {
=======
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConvexPolygonTest {
    
    private ConvexPolygon convexPolygon;
    private List<TwoDimensionalVector> vectors = new ArrayList<>();

    @BeforeEach
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
        ShapeException exception = assertThrows(ShapeException.class, () -> convexPolygon.add(new Circle(1)));
        assertEquals("Illegal Operation", exception.getMessage());
    }
    
    @Test
    public void testConvexPolygonIterator()
    {
        assertTrue(convexPolygon.iterator() instanceof NullIterator);
        assertFalse(convexPolygon.iterator().hasNext());
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> convexPolygon.iterator().next());
        assertEquals("Null iterator does not point to any element", exception.getMessage());
    }

    @Test
    public void testConvexPolygonWithCollinear() throws Exception {
        vectors.clear();
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(6, 0));
        vectors.add(new TwoDimensionalVector(9, 0));
        ShapeException exception = assertThrows(ShapeException.class, () -> new ConvexPolygon(vectors));
        assertEquals(exception.getMessage(), "It's not a convex polygon!");
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
        vectors.clear();
        vectors.add(new TwoDimensionalVector(1, 1));
        vectors.add(new TwoDimensionalVector(4, 1));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(1, 3));
        vectors.add(new TwoDimensionalVector(2, 2));
        ShapeException exception = assertThrows(ShapeException.class, () -> new ConvexPolygon(vectors));
        assertEquals(exception.getMessage(), "It's not a convex polygon!");
    }
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
}