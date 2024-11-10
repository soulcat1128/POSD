package org.ntut.posd2024f.shapes;

public class TwoDimensionalVector {
    private int x;
    private int y;

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
        return new TwoDimensionalVector(this.x - v.x, this.y - v.y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "[" +this.x + "," + this.y + "]";
    }
}