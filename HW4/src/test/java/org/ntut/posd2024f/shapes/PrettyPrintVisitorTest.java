package org.ntut.posd2024f.shapes;

<<<<<<< HEAD
public class PrettyPrintVisitorTest {
=======
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.w3c.dom.css.Rect;

public class PrettyPrintVisitorTest {

    @Test
    public void testPrettyVisitorCircle()
    {
        Circle circle = new Circle(5);
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        circle.accept(visitor);
        assertEquals("Circle 5.0", visitor.getResult());
    }

    @Test
    public void testPrettyVisitorRectangle()
    {
        Rectangle rectangle = new Rectangle(5, 5);
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        rectangle.accept(visitor);
        assertEquals("Rectangle 5.0 5.0", visitor.getResult());
    }

    @Test
    public void testPrettyVisitorTriangle()
    {
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 0));
        Triangle triangle = new Triangle(vectors);
        triangle.accept(visitor);
        assertEquals("Triangle [0,3] [4,0] [0,0]", visitor.getResult());
    }

    @Test
    public void testPrettyVisitorConvexPolygon()
    {
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(1, 1));
        vectors.add(new TwoDimensionalVector(4, 1));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(1, 3));
        ConvexPolygon polygon = new ConvexPolygon(vectors);
        polygon.accept(visitor);
        assertEquals("ConvexPolygon [1,1] [4,1] [4,3] [1,3]", visitor.getResult());
    }

    @Test
    public void testPrettyVisitorCompoundShape()
    {
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(1, 1));
        vectors.add(new TwoDimensionalVector(4, 1));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(1, 3));
        ConvexPolygon polygon = new ConvexPolygon(vectors);
        Rectangle rectangle = new Rectangle(5, 5);
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(polygon);
        compoundShape.add(rectangle);
        compoundShape.accept(visitor);
        assertEquals("CompoundShape {\n  ConvexPolygon [1,1] [4,1] [4,3] [1,3]\n  Rectangle 5.0 5.0\n}", visitor.getResult());
    }

    @Test
    public void testPrettyVIsitorCompoundShapeInCompoundShape()
    {
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(1, 1));
        vectors.add(new TwoDimensionalVector(4, 1));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(1, 3));
        ConvexPolygon polygon = new ConvexPolygon(vectors);
        Rectangle rectangle = new Rectangle(5, 5);
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(polygon);
        compoundShape.add(rectangle);
        CompoundShape compoundShape2 = new CompoundShape();
        compoundShape2.add(new Circle(5));
        compoundShape.add(compoundShape2);
        compoundShape.accept(visitor);
        assertEquals("CompoundShape {\n  ConvexPolygon [1,1] [4,1] [4,3] [1,3]\n  Rectangle 5.0 5.0\n  CompoundShape {\n    Circle 5.0\n  }\n}", visitor.getResult());
    }

    @Test
    public void testPrettyVisitorTextedShape()
    {
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        TextedShape textedShape = new TextedShape(new Circle(5), "Hello");
        textedShape.accept(visitor);
        assertEquals("Circle 5.0, text: Hello", visitor.getResult());
    }

    @Test
    public void testPrettyVisitorTextedShapeInCompoundShape()
    {
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        TextedShape textedShape = new TextedShape(new Circle(5), "Hello");
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(textedShape);
        compoundShape.accept(visitor);
        assertEquals("CompoundShape {\n  Circle 5.0, text: Hello\n}", visitor.getResult());
    }

    @Test
    public void testPrettyVisitorColoredShape()
    {
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        ColoredShape coloredShape = new ColoredShape(new Circle(1), "\033[0;31m");
        coloredShape.accept(visitor);
        assertEquals("\033[0;31mCircle 1.0\033[0m", visitor.getResult());
    }

    @Test
    public void testPrettyVisitorEmptyCompoundShape()
    {
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.accept(visitor);
        assertEquals("CompoundShape {}", visitor.getResult());
    }

    @Test
    public void testPrettyVisitorComplexShape()
    {
        CompoundShape compoundShape1 = new CompoundShape();
        Circle circle = new Circle(5);
        compoundShape1.add(circle);
        CompoundShape compoundShape2 = new CompoundShape();
        ColoredShape  coloredShape = new ColoredShape(compoundShape2, "RED");
        Rectangle rectangle = new Rectangle(5, 5);
        coloredShape.add(rectangle);
        compoundShape1.add(coloredShape);
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        compoundShape1.accept(visitor);
        assertEquals("CompoundShape {\n  Circle 5.0\n  \033[0;31mCompoundShape {\n    Rectangle 5.0 5.0\n  }\033[0m\n}", visitor.getResult());
    }

    @Test
    public void testPrettyVisitorCompoundShapeWithColorShape()
    {
        CompoundShape outterCompoundShape = new CompoundShape();
        Circle outtercircle = new Circle(6);
        outterCompoundShape.add(outtercircle);
        CompoundShape colorCompoundShape = new CompoundShape();
        Circle circle = new Circle(5);
        ColoredShape coloredCompoundShape = new ColoredShape(colorCompoundShape, "RED");
        coloredCompoundShape.add(circle);
        CompoundShape innerColorCompoundShape = new CompoundShape();
        Rectangle rectangle = new Rectangle(5, 5);
        innerColorCompoundShape.add(rectangle);
        coloredCompoundShape.add(innerColorCompoundShape);
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        outterCompoundShape.add(coloredCompoundShape);
        outterCompoundShape.accept(visitor);
        assertEquals("CompoundShape {\n  Circle 6.0\n  \033[0;31mCompoundShape {\n    Circle 5.0\n    CompoundShape {\n      Rectangle 5.0 5.0\n    }\n  }\033[0m\n}", visitor.getResult());
        
    }

    @Test
    public void testPrettyVIsitorCompoundShapeInCompoundShape2()
    {
        CompoundShape outterCompoundShape = new CompoundShape();
        Circle outtercircle = new Circle(6);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(1, 1));
        vectors.add(new TwoDimensionalVector(4, 1));
        vectors.add(new TwoDimensionalVector(4, 3));
        outterCompoundShape.add(outtercircle);
        CompoundShape innerCompoundShape = new CompoundShape();
        ColoredShape coloredCompoundShape = new ColoredShape(innerCompoundShape, "RED");
        Triangle innerTriangle = new Triangle(vectors);
        outterCompoundShape.add(coloredCompoundShape);
        CompoundShape innerinnerCompoundShape = new CompoundShape();
        innerinnerCompoundShape.add(innerTriangle);
        innerCompoundShape.add(innerinnerCompoundShape);
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        outterCompoundShape.accept(visitor);
        assertEquals("CompoundShape {\n  Circle 6.0\n  \033[0;31mCompoundShape {\n    CompoundShape {\n      Triangle [1,1] [4,1] [4,3]\n    }\n  }\033[0m\n}", visitor.getResult());
    }
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
}
