package org.ntut.posd2024f.shapes;

<<<<<<< HEAD
public class FindShapeVisitorTest {
=======
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FindShapeVisitorTest {

    @Test
    public void testFindShapeVisitorCircle()
    {
        FindShapeVisitor visitor = new FindShapeVisitor(c -> c.area() < 1000);
        Circle circle = new Circle(5);
        circle.accept(visitor);
        assertEquals(1, visitor.getResult().size());
        assertEquals(circle, visitor.getResult().get(0));
    }

    @Test
    public void testFindShapeVisitorRectangle()
    {
        FindShapeVisitor visitor = new FindShapeVisitor(r -> r.area() < 1000);
        Rectangle rectangle = new Rectangle(5, 5);
        rectangle.accept(visitor);
        assertEquals(1, visitor.getResult().size());
        assertEquals(rectangle, visitor.getResult().get(0));
    }

    @Test
    public void testFindShapeVisitorTriangle()
    {
        FindShapeVisitor visitor = new FindShapeVisitor(t -> t.area() < 1000);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 0));
        Triangle triangle = new Triangle(vectors);
        triangle.accept(visitor);
        assertEquals(1, visitor.getResult().size());
        assertEquals(triangle, visitor.getResult().get(0));
    }

    @Test
    public void testFindShapeVisitorConvexPolygon()
    {
        FindShapeVisitor visitor = new FindShapeVisitor(p -> p.area() < 1000);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(1, 1));
        vectors.add(new TwoDimensionalVector(4, 1));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(1, 3));
        ConvexPolygon polygon = new ConvexPolygon(vectors);
        polygon.accept(visitor);
        assertEquals(1, visitor.getResult().size());
        assertEquals(polygon, visitor.getResult().get(0));
    }

    @Test
    public void testFindShapeVisitorCompoundShape()
    {
        FindShapeVisitor visitor = new FindShapeVisitor(s -> s.area() < 1000);
        CompoundShape compoundShape = new CompoundShape();
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(5, 5);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 0));
        Triangle triangle = new Triangle(vectors);
        compoundShape.add(circle);
        compoundShape.add(rectangle);
        compoundShape.add(triangle);
        compoundShape.accept(visitor);
        assertEquals(4, visitor.getResult().size());
        assertEquals(compoundShape, visitor.getResult().get(0));
        assertEquals(circle, visitor.getResult().get(1));
        assertEquals(rectangle, visitor.getResult().get(2));
        assertEquals(triangle, visitor.getResult().get(3));
    }

    @Test
    public void testFindShapeVisitorComplexCompoundShape()
    {
        FindShapeVisitor visitor = new FindShapeVisitor(s -> s.area() < 1000);
        CompoundShape compoundShape = new CompoundShape();
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(5, 5);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 0));
        Triangle triangle = new Triangle(vectors);
        CompoundShape compoundShape2 = new CompoundShape();
        compoundShape2.add(new Circle(5));
        compoundShape2.add(new Rectangle(5, 5));
        compoundShape.add(circle);
        compoundShape.add(rectangle);
        compoundShape.add(triangle);
        compoundShape.add(compoundShape2);
        compoundShape.accept(visitor);
        assertEquals(7, visitor.getResult().size());
        assertEquals(compoundShape, visitor.getResult().get(0));
        assertEquals(circle, visitor.getResult().get(1));
        assertEquals(rectangle, visitor.getResult().get(2));
        assertEquals(triangle, visitor.getResult().get(3));
        assertEquals(compoundShape2, visitor.getResult().get(4));
    }

    @Test
    public void testFindShapeVisitorTextedShape()
    {
        FindShapeVisitor visitor = new FindShapeVisitor(s -> s.area() < 1000);
        Circle circle = new Circle(5);
        TextedShape textedShape = new TextedShape(circle, "Circle");
        textedShape.accept(visitor);
        assertEquals(2, visitor.getResult().size());
        assertEquals(textedShape, visitor.getResult().get(0));
    }

    @Test
    public void testFindShapeVisitorColoredShape()
    {
        FindShapeVisitor visitor = new FindShapeVisitor(s -> s.area() < 1000);
        Circle circle = new Circle(5);
        ColoredShape colorShape = new ColoredShape(circle, "Red");
        colorShape.accept(visitor);
        assertEquals(2, visitor.getResult().size());
        assertEquals(colorShape, visitor.getResult().get(0));
    }

    @Test
    public void testFindShapeNoShape()
    {
        FindShapeVisitor visitor = new FindShapeVisitor(s -> s.area() < 1000);
        Circle circle = new Circle(100);
        circle.accept(visitor);
        assertEquals(0, visitor.getResult().size());
    }

    @Test
    public void testFindShapeWithCompoundShapeNoShape()
    {
        FindShapeVisitor visitor = new FindShapeVisitor(s -> s.area() < 1000);
        CompoundShape compoundShape = new CompoundShape();
        Circle circle = new Circle(100);
        compoundShape.add(circle);
        compoundShape.accept(visitor);
        assertEquals(0, visitor.getResult().size());
    }

>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
}
