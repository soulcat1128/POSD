package org.ntut.posd2024f.shapes;

<<<<<<< HEAD
public class TriangleTest {
=======
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    private Triangle triangle;
    private List<TwoDimensionalVector> vectors = new ArrayList<>();

    @BeforeEach
    public void setUp()
    {
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(0, 4));   
        vectors.add(new TwoDimensionalVector(0, 0));
        triangle = new Triangle(vectors);
    }

    @Test
    public void testTriangleAreaCalculation()
    {   
        assertEquals(triangle.area(), 6.0, 0.01);
    }

    @Test
    public void testTrianglePerimeterCalculation()
    {
        assertEquals(triangle.perimeter(), 12.0, 0.01);    
    }

    @Test
    public void testTriangleAdd()
    {
        List<TwoDimensionalVector> vectorsTest = new ArrayList<>();
        vectorsTest.add(new TwoDimensionalVector(3, 0));
        vectorsTest.add(new TwoDimensionalVector(0, 4));
        vectorsTest.add(new TwoDimensionalVector(0, 0));        
        Triangle triangleTest = new Triangle(vectorsTest);
        ShapeException exception = assertThrows(ShapeException.class,   () -> triangleTest.add(triangle));

        assertEquals("Illegal Operation", exception.getMessage());
    }

    @Test
    public void testTriangleWithCollinear() throws Exception
    {
        vectors.clear();
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(6, 0));
        vectors.add(new TwoDimensionalVector(9, 0));

        ShapeException exception = assertThrows(ShapeException.class, () -> new Triangle(vectors));
        assertEquals(exception.getMessage(), "It's not a triangle!");
    }

    @Test
    public void testTriangleWhenInvalidVectors() throws Exception
    {
        vectors.clear();
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(0, 4));
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(0, 0));
        ShapeException exception = assertThrows(ShapeException.class, () -> new Triangle(vectors));
        assertEquals(exception.getMessage(), "It's not a triangle!");
    }

    @Test
    public void testTriangleWithIterator()
    {
        assertTrue(triangle.iterator() instanceof NullIterator);
        assertFalse(triangle.iterator().hasNext());
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, ()->{triangle.iterator().next();});
        assertEquals(exception.getMessage(), "Null iterator does not point to any element");
    }
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
}