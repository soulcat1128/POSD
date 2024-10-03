package org.ntut.posd2024f.shapes;

public class TwoDimensionalVector {

    // #TODO: check if the x and y are public
    public int x;
    public int y;

    public TwoDimensionalVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public int dot(TwoDimensionalVector v) {
        return this.x * v.x + this.y * v.y;
    }

    public int cross(TwoDimensionalVector v) {
        return this.x * v.y - this.y * v.x;
    }

    public TwoDimensionalVector subtract(TwoDimensionalVector v) {
    }
}