package org.ntut.posd2024f.shapes;

public class Circle implements Shape {
    private double radius;
    public Circle(double radius) throws Exception {
        if(radius <= 0)
        {
            throw new Exception("It's not a circle!");
        }
        this.radius = radius;
    }

    public double area() {
        return Math.PI * this.radius * this.radius;
    } 

    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }

    public String toString() {
        return new String("Circle " + Double.valueOf(this.radius));
    }
}
