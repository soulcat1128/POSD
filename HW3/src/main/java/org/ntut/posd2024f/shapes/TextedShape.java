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
    }

    @Override
    public Iterator<Shape> iterator() {
    }

    public Shape getShape() {
    }

    public String getText() {
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
    }
}
