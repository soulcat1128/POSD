package org.ntut.posd2024f.shapes;

public class Rectangle implements Shape {
    private double length, width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

	public double area() {
        return this.length * this.width;
    }
    
    public double perimeter() {
        return this.length * 2 + this.width * 2;
    }
}