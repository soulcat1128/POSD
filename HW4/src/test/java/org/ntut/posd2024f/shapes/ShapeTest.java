package org.ntut.posd2024f.shapes;

<<<<<<< HEAD
public class ShapeTest {
=======
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShapeTest {
    
    private Circle c;
    private Rectangle r;
    private Triangle t;
    private ConvexPolygon cp;
    private CompoundShape cs;
    private TextedShape ts;
    private ColoredShape cc;

    List<TwoDimensionalVector> vectors = new ArrayList<>();
    List<TwoDimensionalVector> vectorsConvexPolygon = new ArrayList<>();

    @BeforeEach
    public void setUp()
    {
        c = new Circle(5.0);
        r = new Rectangle(4.0, 5.0);
        ts = new TextedShape(r, "Rectangle");
        cc = new ColoredShape(ts, "Red");

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
        assertTrue(ts instanceof Shape);
        assertTrue(cc instanceof Shape);
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
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            s.add(s2);
        });
        assertEquals(exception.getMessage(), "Illegal Operation");
        
    }

    @Test
    public void testDefaultMethodIterator()
    {
        Shape s = new Circle(1.0);
        
        assertFalse(s.iterator().hasNext());
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            s.iterator().next();
        });
        assertEquals(exception.getMessage(), "Null iterator does not point to any element");
    }
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
}