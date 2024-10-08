package org.ntut.posd2024f.shapes;

import java.util.List;
import java.util.function.Predicate;

public class FindShapeVisitor implements Visitor<List<Shape>> {
    public FindShapeVisitor(Predicate<Shape> condition) {
    }

    @Override
    public void visitCircle(Circle circle) {
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
    }

    @Override
    public void visitTriangle(Triangle triangle) {
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
    }

    @Override
    public void visitTextedShape(TextedShape textedShape) {
    }

    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
    }

    public List<Shape> getResult() {
    }
}