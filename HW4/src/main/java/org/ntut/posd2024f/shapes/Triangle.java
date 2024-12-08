package org.ntut.posd2024f.shapes;

import java.util.List;

public class Triangle implements Shape {
    private List<TwoDimensionalVector> vectors;

    public Triangle(List<TwoDimensionalVector> vectors) {
        if(!isTriangle(vectors) || vectors == null) {
            throw new ShapeException("It's not a triangle!");
        }
        this.vectors = vectors;
    }

    @Override
    public double perimeter() {
        double sum = 0;
        for(int i = 0; i < 3; i++)
        {
            sum += vectors.get(i).subtract(vectors.get((i + 1) % 3)).length();
        }
        return sum;
    }

    @Override
    public double area() {
        double sum = 0;
        for(int i = 0; i < 3; i++)
        {
            sum += vectors.get(i).cross(vectors.get((i + 1) % 3));
        }
        return Math.abs(sum) / 2.0;
    }

    private boolean isTriangle(List<TwoDimensionalVector> vectors) {
        if(vectors.size() != 3) {
            return false;
        }
        int n = vectors.size();
        for(int i = 0; i < n; i++) {
            TwoDimensionalVector a = vectors.get(i);
            TwoDimensionalVector b = vectors.get((i + 1) % n);
            TwoDimensionalVector c = vectors.get((i + 2) % n);

            TwoDimensionalVector ab = b.subtract(a);
            TwoDimensionalVector bc = c.subtract(b);

            int crossProduct = ab.cross(bc);

            if(crossProduct == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitTriangle(this);
    }

    public List<TwoDimensionalVector> getVectors() {
        return this.vectors;
    }
}
