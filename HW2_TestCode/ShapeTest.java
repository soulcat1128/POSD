package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ShapeTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Circle c;
    private Rectangle r;
    private Triangle t;
    private ConvexPolygon cp;
    private CompoundShape cs;

    List<TwoDimensionalVector> vectors = new ArrayList<>();
    List<TwoDimensionalVector> vectorsConvexPolygon = new ArrayList<>();

    @Before
    public void setUp()
    {
        c = new Circle(5.0);
        r = new Rectangle(4.0, 5.0);

        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(0, 4));
        vectors.add(new TwoDimensionalVector(0, 0));
        t = new Triangle(vectors);
        
        vectorsConvexPolygon.add(new TwoDimensionalVector(1, 1));
        vectorsConvexPolygon.add(new TwoDimensionalVector(3, 1));
        vectorsConvexPolygon.add(new TwoDimensionalVector(3, 4));
        vectorsConvexPolygon.add(new TwoDimensionalVector(1, 4));
        cp = new ConvexPolygon(vectorsConvexPolygon);
        cs = new CompoundShape();
    }

    @Test
    public void testCircle() throws Exception
    {
        assertEquals(Math.PI * 5.0 * 5.0, c.area(), 0.01);
        assertEquals(2 * Math.PI * 5.0, c.perimeter(), 0.01);
    }

    @Test
    public void testInstance() throws Exception
    {
        assertTrue(c instanceof Shape);
        assertTrue(r instanceof Shape);
        assertTrue(t instanceof Shape);
        assertTrue(cp instanceof Shape);
        assertTrue(cs instanceof Shape);
    }

    @Test
    public void testTriangle() throws Exception
    {
        assertEquals(t.area(), 6.0, 0.01);
        assertEquals(t.perimeter(), 12.0, 0.01);
    }

    @Test
    public void testRectangle() throws Exception
    {
        assertEquals(20.0, r.area(), 0.01);
        assertEquals(18.0, r.perimeter(), 0.01);
    }

    @Test
    public void testConvexPolygon()
    {
        assertEquals(6.0, cp.area(), 0.01);
        assertEquals(10.0, cp.perimeter(), 0.01);
    }

    @Test
    public void testCompoundShape() throws Exception
    {
        cs.add(c);
        cs.add(r);
        cs.add(t);
        cs.add(cp);
        double totalArea = c.area() + r.area() + t.area() + cp.area();
        double totalPerimeter = c.perimeter() + r.perimeter() + t.perimeter() + cp.perimeter();

        assertEquals(totalArea, cs.area(), 0.01);
        assertEquals(totalPerimeter, cs.perimeter(), 0.01);
    }

    @Test
    public void testDefaultMethodAdd()
    {
        Shape s = new Circle(1.0);
        Shape s2 = new Circle(2.0);
        thrown.expect(ShapeException.class);
        thrown.expectMessage("Illegal Operation");
        s.add(s2);
    }

    @Test
    public void testDefaultMethodIterator()
    {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Null iterator does not point to any element");        
        Shape s = new Circle(1.0);

        assertFalse(s.iterator().hasNext());
        s.iterator().next();
    }
    
}