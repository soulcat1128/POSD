package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public class TextedShape implements Shape {
    private Shape shape;
    private String text;

    public TextedShape(Shape shape, String text) {
        this.text = text;
        this.shape = shape;
    }

    @Override
    public double area() {
        return this.shape.area();
    }

    @Override
    public double perimeter() {
        return this.shape.perimeter();
    }
    
    @Override
    public void add(Shape shape) {
        this.shape.add(shape);
    }

    @Override
    public Iterator<Shape> iterator() {
        return this.shape.iterator();
    }

    public Shape getShape() {
        return this.shape;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitTextedShape(this);
    }
}
