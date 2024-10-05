package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public interface Shape {
    public double area();
    public double perimeter();
    public default void add(Shape shape) {
        throw new ShapeException("Illegal Operation");
    }
    public default Iterator<Shape> iterator() {
        return new NullIterator();
    }
}
