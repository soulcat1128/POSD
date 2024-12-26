package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 設計模式中 組合模式 實現
public class CompoundShape implements Shape {
    private List<Shape> shapes;
    public CompoundShape() {
        this.shapes = new ArrayList<Shape>();
    }
    
    public double area() {
        double sum = 0;
        for(Shape shape : shapes) {
            sum += shape.area();
        }
        return sum;
    }

    public double perimeter() {
        double sum = 0;
        for(Shape shape : shapes) {
            sum += shape.perimeter();
        }
        return sum;
    }

    @Override
    public void add(Shape shape) {
        if (shape != null)
        {
            this.shapes.add(shape);
        }
    }

    @Override
    public Iterator<Shape> iterator() {
        return new CompositeShapeIterator();
    }

    private class CompositeShapeIterator implements Iterator<Shape> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < shapes.size();
        }

        @Override
        public Shape next() {
            if (index >= shapes.size()) {
                return null;
            }
            return shapes.get(index++);
        }
    }
}
