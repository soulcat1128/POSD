package org.ntut.posd2024f.shapes;

public class Circle implements Shape {
    private double radius;
    public Circle(double radius) {
        if (radius <= 0) {
            throw new ShapeException("It's not a circle!");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    } 

    @Override
    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitCircle(this);
    }

    public double getRadius() {
        return this.radius;
    }
}
