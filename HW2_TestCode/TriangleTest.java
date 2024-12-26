package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TriangleTest {
    
    private Triangle triangle;
    private List<TwoDimensionalVector> vectors = new ArrayList<>();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
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
        thrown.expect(ShapeException.class);
        thrown.expectMessage("Illegal Operation");
        List<TwoDimensionalVector> vectorsTest = new ArrayList<>();
        vectorsTest.add(new TwoDimensionalVector(3, 0));
        vectorsTest.add(new TwoDimensionalVector(0, 4));
        vectorsTest.add(new TwoDimensionalVector(0, 0));        

        Triangle triangleTest = new Triangle(vectorsTest);
        triangleTest.add(triangleTest);
    }

    @Test
    public void testTriangleWithCollinear() throws Exception
    {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a triangle!");
        vectors.clear();
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(6, 0));
        vectors.add(new TwoDimensionalVector(9, 0));
        new Triangle(vectors);
    }

    @Test
    public void testTriangleWhenInvalidVectors() throws Exception
    {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a triangle!");
        vectors.clear();
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(0, 4));
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(0, 0));
        new Triangle(vectors);
    }

    @Test
    public void testTriangleWithIterator()
    {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Null iterator does not point to any element");

        assertTrue(triangle.iterator() instanceof NullIterator);
        assertFalse(triangle.iterator().hasNext());
        triangle.iterator().next();
    }
}