package org.ntut.posd2024f.shapes;

public class PrettyPrintVisitor implements Visitor<String>{
    private String result;

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

    @Override
    public String getResult() {
        return this.result;
    }
}
