package org.ntut.posd2024f.shapes;

public interface Visitor<T> {
    public void visitCircle(Circle circle);
    public void visitRectangle(Rectangle rectangle);
    public void visitTriangle(Triangle triangle);
    public void visitConvexPolygon(ConvexPolygon convexPolygon);
    public void visitCompoundShape(CompoundShape compoundShape);
    public void visitTextedShape(TextedShape textedShape);
    public void visitColoredShape(ColoredShape coloredShape);
    public T getResult();
}
