package org.ntut.posd2024f.shapes;

public class Rectangle implements Shape {
    private double length, width;
    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new ShapeException("It's not a rectangle!");
        }
        this.length = length;
        this.width = width;
    }

    @Override
	public double area() {
        return this.length * this.width;
    }
    
    @Override
    public double perimeter() {
        return this.length * 2 + this.width * 2;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitRectangle(this);
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }
}