package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class FindShapeVisitor implements Visitor<List<Shape>> {
    private List<Shape> result;
    private Predicate<Shape> condition;

    public FindShapeVisitor(Predicate<Shape> condition) {
        this.condition = condition;
        this.result = new ArrayList<>();
    }

    @Override
    public void visitCircle(Circle circle) {
        if (condition.test(circle))
        {
            result.add(circle);
        }
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        if (condition.test(rectangle))
        {
            result.add(rectangle);
        }
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        if (condition.test(triangle))
        {
            result.add(triangle);
        }
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
        if (condition.test(convexPolygon))
        {
            result.add(convexPolygon);
        }
    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
        if (condition.test(compoundShape))
        {
            result.add(compoundShape);
        }
        Iterator<Shape> it = compoundShape.iterator();
        while (it.hasNext())
        {
            FindShapeVisitor visitor = new FindShapeVisitor(condition);
            Shape shape = it.next();
            shape.accept(visitor);
            if (visitor.getResult().size() > 0)
            {
                for(Shape s : visitor.getResult())
                {
                    result.add(s);
                }
            }
        }
    }

    @Override
    public void visitTextedShape(TextedShape textedShape) {
        if (condition.test(textedShape))
        {
            result.add(textedShape);
        }
        if (textedShape != null)
        {
            FindShapeVisitor visitor = new FindShapeVisitor(condition);
            textedShape.getShape().accept(visitor);
            if (visitor.getResult().size() > 0)
            {
                for(Shape s : visitor.getResult())
                {
                    result.add(s);
                }
            }
        }
    }
    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
        if (coloredShape != null)
        {
            if (condition.test(coloredShape))
            {
                result.add(coloredShape);
            }
            FindShapeVisitor visitor = new FindShapeVisitor(condition);
            coloredShape.getShape().accept(visitor);
            if (visitor.getResult().size() > 0)
            {
                for(Shape s : visitor.getResult())
                {
                    result.add(s);
                }
            }
        }
    }

    public List<Shape> getResult() {
        return this.result;
    }
}