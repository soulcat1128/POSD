package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SortTest {

    private Circle circle;
    private Triangle triangle;
    private Rectangle rectangle;
    private ArrayList<Shape> shapes = new ArrayList<>();
    private List<TwoDimensionalVector> vectors = new ArrayList<>();
    private CompoundShape compoundShape = new CompoundShape();


    @Before
    public void setUp() throws Exception
    {
        circle = new Circle(5.0);    // area : 78.5, perimeter : 31.4
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(0, 4));
        vectors.add(new TwoDimensionalVector(0, 0));
        triangle = new Triangle(vectors);   // area : 6, perimeter : 12
        rectangle = new Rectangle(3.0, 5.0);    // area : 15, perimeter : 16
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);
        for(Shape shape : shapes)
        {
            compoundShape.add(shape);
        }
    }

    @Test
    public void testAreaAscending() throws Exception
    {
        Collections.sort(shapes, Sort.BY_AREA_ASCENDING);

        assertEquals(triangle , shapes.get(0));
        assertEquals(rectangle , shapes.get(1));
        assertEquals(circle , shapes.get(2));
    }

    @Test
    public void testAreaDescending() throws Exception
    {
        Collections.sort(shapes, Sort.BY_AREA_DESCENDING);
        
        assertEquals(circle , shapes.get(0));
        assertEquals(rectangle , shapes.get(1));
        assertEquals(triangle , shapes.get(2));
    }

    @Test
    public void testPerimeterAscending() throws Exception
    {
        Collections.sort(shapes, Sort.BY_PERIMETER_ASCENDING);
        
        assertEquals(triangle , shapes.get(0));
        assertEquals(rectangle , shapes.get(1));
        assertEquals(circle , shapes.get(2));
    }

    @Test
    public void testPerimeterDescending() throws Exception
    {
        Collections.sort(shapes, Sort.BY_PERIMETER_DESCENDING);
        
        assertEquals(circle , shapes.get(0));
        assertEquals(rectangle , shapes.get(1));
        assertEquals(triangle , shapes.get(2));
    }

    @Test
    public void testEmptyList() throws Exception
    {
        shapes.clear();
        Collections.sort(shapes, Sort.BY_AREA_ASCENDING);
        assertTrue(shapes.isEmpty());
    }

    @Test
    public void testSameElement() throws Exception
    {
        Circle sameCircle = new Circle(5.0);
        shapes.clear();
        shapes.add(circle);
        shapes.add(sameCircle);

        assertEquals(circle, shapes.get((0)));
        assertEquals(sameCircle, shapes.get((1)));
    }


    @Test
    public void testSortCompoundShape() throws Exception
    {
        Collections.sort(compoundShape.shapes, Sort.BY_AREA_ASCENDING);

        assertEquals(triangle , compoundShape.shapes.get(0));
        assertEquals(rectangle , compoundShape.shapes.get(1));
        assertEquals(circle , compoundShape.shapes.get(2));
    }
}