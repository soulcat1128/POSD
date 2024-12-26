package org.ntut.posd2024f.shapes;

<<<<<<< HEAD
public class CompoundShapeTest {
=======
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompoundShapeTest {
    private CompoundShape compoundShape;
    private Circle circle;
    private Rectangle rectangle;
    private Triangle triangle;
    private List<TwoDimensionalVector> vectors = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        compoundShape = new CompoundShape();
        circle = new Circle(1);
        rectangle = new Rectangle(1, 1);
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(0, 4));
        vectors.add(new TwoDimensionalVector(0, 0));
        triangle = new Triangle(vectors);
        compoundShape.add(circle);
        compoundShape.add(rectangle);
        compoundShape.add(triangle);        
    }

    @Test
    public void testCompoundShapeArea()
    {
        double ans = 1 + Math.PI + 6;
        assertEquals(compoundShape.area(), ans, 0.01);
    }

    @Test
    public void testCompoundShapePerimeter()
    {
        double ans = 4 + 2 * Math.PI + 12;
        assertEquals(compoundShape.perimeter(), ans, 0.01);
    }

    @Test
    public void testCompoundShapeAdd()
    {
        Circle newCircle = new Circle(2);
        compoundShape.add(newCircle);
        assertEquals(compoundShape.getShapes().get(3), newCircle);
    }

    @Test
    public void testCompoundShapeIterator()
    {
        Iterator<Shape> it = compoundShape.iterator();

        assertTrue(it.hasNext());
        assertEquals(it.next(), circle);
        assertEquals(it.next(), rectangle);
        assertEquals(it.next(), triangle);
        assertFalse(it.hasNext());
    }

    @Test
    public void testComplexCompoundShapeAreaAndPerimeter()
    {
        CompoundShape complexCompoundShape = new CompoundShape();
        complexCompoundShape.add(compoundShape);
        complexCompoundShape.add(new Circle(2));
        complexCompoundShape.add(new Rectangle(2, 2));

        double ans = 1 + Math.PI + 6 + 4 + 4 * Math.PI;
        assertEquals(complexCompoundShape.area(), ans, 0.01);

        double ans2 = 4 + 2 * Math.PI + 12 + 4 * Math.PI + 8;
        assertEquals(complexCompoundShape.perimeter(), ans2, 0.01);
    }

    @Test
    public void testComplexCompoundShapeIterator()
    {
        CompoundShape complexCompoundShape = new CompoundShape();
        Circle newCircle = new Circle(2);
        Rectangle newRectangle = new Rectangle(2, 2);
        complexCompoundShape.add(compoundShape);
        complexCompoundShape.add(newCircle);
        complexCompoundShape.add(newRectangle);

        Iterator<Shape> it = complexCompoundShape.iterator();

        assertTrue(it.hasNext());
        assertEquals(it.next(), compoundShape);
        assertEquals(it.next(), newCircle);
        assertEquals(it.next(), newRectangle);
        assertFalse(it.hasNext());
    }

    @Test
    public void testEmptyCompoundShape()
    {
        CompoundShape emptyCompoundShape = new CompoundShape();
        assertEquals(emptyCompoundShape.area(), 0, 0.01);
        assertEquals(emptyCompoundShape.perimeter(), 0, 0.01);
        assertFalse(emptyCompoundShape.iterator().hasNext());
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, ()->{emptyCompoundShape.iterator().next();});
        assertEquals(exception.getMessage(), "Null iterator does not point to any element");
    }

    @Test
    public void testCompoundShapeGetShape()
    {
        List<Shape> shapes = compoundShape.getShapes();
        assertEquals(shapes.get(0), circle);
        assertEquals(shapes.get(1), rectangle);
        assertEquals(shapes.get(2), triangle);
    }
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
}
