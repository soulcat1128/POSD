package org.ntut.posd2024f.shapes;

<<<<<<< HEAD
public class TextedShapeTest {
}
=======
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class TextedShapeTest {
    @Test
    public void testTextedShapeCircle()
    {
        Circle circle = new Circle(5);
        TextedShape textedCircle = new TextedShape(circle, "Circle");
        assertEquals(5 * 5 * Math.PI, textedCircle.area(), 0.01);
        assertEquals(2 * 5 * Math.PI, textedCircle.perimeter(), 0.01);
        Iterator<Shape> iterator = textedCircle.iterator();
        assertFalse(iterator.hasNext());
        assertEquals(textedCircle.getShape(), circle);
        assertEquals(textedCircle.getText(), "Circle");
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        textedCircle.accept(visitor);
        assertEquals(visitor.getResult(), "Circle 5.0, text: Circle");
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            textedCircle.add(new Circle(5));
        });
        assertEquals(exception.getMessage(), "Illegal Operation");
    }

    @Test
    public void testTextedShapeGetShapeAndGetText()
    {
        Circle circle = new Circle(5);
        TextedShape textedCircle = new TextedShape(circle, "Hello");
        assertEquals(circle, textedCircle.getShape());
        assertEquals("Hello", textedCircle.getText());
    }

    @Test
    public void testTextedColoredShape()
    {
        Circle circle = new Circle(5);
        ColoredShape coloredCircle = new ColoredShape(circle, "Red");
        TextedShape textedColoredCircle = new TextedShape(coloredCircle, "Circle");
        assertEquals(5 * 5 * Math.PI, textedColoredCircle.area(), 0.01);
        assertEquals(2 * 5 * Math.PI, textedColoredCircle.perimeter(), 0.01);
        assertEquals(textedColoredCircle.getShape(), coloredCircle);
        assertEquals(textedColoredCircle.getText(), "Circle");
        assertEquals(((ColoredShape)textedColoredCircle.getShape()).getColor(), "Red");
        assertEquals(((ColoredShape)textedColoredCircle.getShape()).getShape(), circle);
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        textedColoredCircle.accept(visitor);
        assertEquals(visitor.getResult(), "\033[0;31mCircle 5.0\033[0m, text: Circle");
    }

    @Test
    public void testTextedCompound()
    {
        CompoundShape compound = new CompoundShape();
        Circle circle = new Circle(5);
        compound.add(circle);
        TextedShape textedCompound = new TextedShape(compound, "Compound");
        assertEquals(5 * 5 * Math.PI, textedCompound.area(), 0.01);
        assertEquals(2 * 5 * Math.PI, textedCompound.perimeter(), 0.01);
        assertEquals(textedCompound.getShape(), compound);
        assertEquals(textedCompound.getText(), "Compound");
        Iterator<Shape> iterator = textedCompound.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), circle);
        assertFalse(iterator.hasNext());
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        textedCompound.accept(visitor);
        assertEquals(visitor.getResult(), "CompoundShape {\n  Circle 5.0\n}, text: Compound");
    }

    @Test
    public void testTextedComplexCompoundShape()
    {
        CompoundShape compound = new CompoundShape();
        Circle circle = new Circle(5);
        compound.add(circle);
        CompoundShape compound2 = new CompoundShape();
        ColoredShape coloredCompoundShape = new ColoredShape(compound2, "RED");
        compound.add(coloredCompoundShape);
        TextedShape textedCompound = new TextedShape(compound, "Compound");
        assertEquals(5 * 5 * Math.PI, textedCompound.area(), 0.01);
        assertEquals(2 * 5 * Math.PI, textedCompound.perimeter(), 0.01);
        assertEquals(textedCompound.getShape(), compound);
        assertEquals(textedCompound.getText(), "Compound");
        Iterator<Shape> iterator = textedCompound.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), circle);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), coloredCompoundShape);
        assertFalse(iterator.hasNext());
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        textedCompound.accept(visitor);
        assertEquals(visitor.getResult(), "CompoundShape {\n  Circle 5.0\n  \033[0;31mCompoundShape {}\033[0m\n}, text: Compound");
    }
}

>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
