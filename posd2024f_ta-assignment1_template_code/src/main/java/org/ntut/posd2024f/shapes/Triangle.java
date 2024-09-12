package org.ntut.posd2024f.shapes;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class Triangle implements Shape
{
    private double a, b, c;
    Triangle(double a, double b, double c) throws Exception {
        if(a < 0 || b < 0 || c < 0)
        {
            throw new Exception("It's not a triangle!");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimeter() {
        return a+b+c;
    }

    public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public String toString() {
        return String.format("Triangle %.2f %.2f %.2f", this.a, this.b, this.c);
    }
}
