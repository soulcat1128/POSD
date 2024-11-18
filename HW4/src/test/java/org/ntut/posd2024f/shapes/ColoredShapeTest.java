package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class ColoredShapeTest {

    @Test
    public void testColoredShapeCircle()
    {
        Circle circle = new Circle(5);
        ColoredShape coloredCircle = new ColoredShape(circle, "RED");
        assertEquals(5 * 5 * Math.PI, coloredCircle.area(), 0.01);
        assertEquals(2 * 5 * Math.PI, coloredCircle.perimeter(), 0.01);
        Iterator<Shape> iterator = coloredCircle.iterator();
        assertFalse(iterator.hasNext());
        assertEquals(coloredCircle.getShape(), circle);
        assertEquals(coloredCircle.getColor(), "RED");
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        coloredCircle.accept(visitor);
        assertEquals(visitor.getResult(), "\033[0;31mCircle 5.0\033[0m");
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            coloredCircle.add(new Circle(5));
        });
        assertEquals(exception.getMessage(), "Illegal Operation");
    }

    @Test
    public void testColoredTextedShape()
    {
        Circle circle = new Circle(5);
        TextedShape textedCircle = new TextedShape(circle, "Circle");
        ColoredShape coloredCircle = new ColoredShape(textedCircle, "RED");
        assertEquals(5 * 5 * Math.PI, coloredCircle.area(), 0.01);
        assertEquals(2 * 5 * Math.PI, coloredCircle.perimeter(), 0.01);
        assertEquals(coloredCircle.getShape(), textedCircle);
        assertEquals(coloredCircle.getColor(), "RED");
        assertEquals(((TextedShape)coloredCircle.getShape()).getText(), "Circle");
        assertEquals(((TextedShape)coloredCircle.getShape()).getShape(), circle);
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        coloredCircle.accept(visitor);
        assertEquals(visitor.getResult(), "\033[0;31mCircle 5.0, text: Circle\033[0m");
    }

    @Test
    public void testColoredCompoundShape()
    {
        CompoundShape compound = new CompoundShape();
        Circle circle = new Circle(5);
        compound.add(circle);
        ColoredShape coloredCompound = new ColoredShape(compound, "RED");
        assertEquals(5 * 5 * Math.PI, coloredCompound.area(), 0.01);
        assertEquals(2 * 5 * Math.PI, coloredCompound.perimeter(), 0.01);
        assertEquals(coloredCompound.getShape(), compound);
        assertEquals(coloredCompound.getColor(), "RED");
        Iterator<Shape> iterator = coloredCompound.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), circle);
        assertFalse(iterator.hasNext());
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        coloredCompound.accept(visitor);
        assertEquals(visitor.getResult(), "\033[0;31mCompoundShape {\n  Circle 5.0\n}\033[0m");
    }

    @Test
    public void testColoredComplexCompoundShape()
    {
        CompoundShape compound = new CompoundShape();
        Circle circle = new Circle(5);
        compound.add(circle);
        CompoundShape compound2 = new CompoundShape();
        ColoredShape coloredCompoundShape = new ColoredShape(compound2, "RED");
        compound.add(coloredCompoundShape);
        ColoredShape coloredCompound = new ColoredShape(compound, "RED");
        assertEquals(5 * 5 * Math.PI, coloredCompound.area(), 0.01);
        assertEquals(2 * 5 * Math.PI, coloredCompound.perimeter(), 0.01);
        assertEquals(coloredCompound.getShape(), compound);
        assertEquals(coloredCompound.getColor(), "RED");
        Iterator<Shape> iterator = coloredCompound.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), circle);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), coloredCompoundShape);
        assertFalse(iterator.hasNext());
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        coloredCompound.accept(visitor);
        assertEquals(visitor.getResult(), "\033[0;31mCompoundShape {\n  Circle 5.0\n  \033[0;31mCompoundShape {}\033[0m\n}\033[0m");
    }
}
