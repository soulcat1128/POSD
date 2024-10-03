package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public interface Shape {
    public double area();
    public double perimeter();
    public default void add(Shape shape) {
    }
    public default Iterator<Shape> iterator() {
    }
}
