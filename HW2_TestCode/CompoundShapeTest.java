package org.ntut.posd2024f.shapes;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CompoundShapeTest {

    private CompoundShape compoundShape;
    private Circle circle;
    private Rectangle rectangle;
    private Triangle triangle;
    private List<TwoDimensionalVector> vectors = new ArrayList<>();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
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
        assertEquals(compoundShape.shapes.get(3), newCircle);
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
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Null iterator does not point to any element");
        CompoundShape emptyCompoundShape = new CompoundShape();
        assertEquals(emptyCompoundShape.area(), 0, 0.01);
        assertEquals(emptyCompoundShape.perimeter(), 0, 0.01);
        assertFalse(emptyCompoundShape.iterator().hasNext());
        emptyCompoundShape.iterator().next();        
    }

}
