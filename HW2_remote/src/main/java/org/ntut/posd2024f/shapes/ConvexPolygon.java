package org.ntut.posd2024f.shapes;

import java.util.List;

public class ConvexPolygon implements Shape {

    private List<TwoDimensionalVector> vectors;

    public ConvexPolygon(List<TwoDimensionalVector> vectors) {
        if(!isConvex(vectors) || vectors.size() < 3 || vectors == null)
        {
            throw new ShapeException("It's not a convex polygon!");
        }
        this.vectors = vectors;
    }

    public double area() {
        double sum = 0;
        int n = vectors.size();
        for (int i = 0; i < n; i++) {
            TwoDimensionalVector v1 = vectors.get(i);
            TwoDimensionalVector v2 = vectors.get((i + 1) % n);
            sum += v1.cross(v2);
        }
        return Math.abs(sum) / 2.0;
    }

    public double perimeter() {
        double sum = 0;
        int n = vectors.size();
        for (int i = 0; i < n; i++) {
            TwoDimensionalVector v1 = vectors.get(i);
            TwoDimensionalVector v2 = vectors.get((i + 1) % n);
            double distance = v1.subtract(v2).length();
            sum += distance;
        }
        return sum;
    }

    private boolean isConvex(List<TwoDimensionalVector> vectors) {
        int n = vectors.size();
        Integer prevCrossProduct = null;
    
        for (int i = 0; i < n; i++) {
            TwoDimensionalVector a = vectors.get(i);
            TwoDimensionalVector b = vectors.get((i + 1) % n);
            TwoDimensionalVector c = vectors.get((i + 2) % n);
    
            TwoDimensionalVector ab = b.subtract(a);
            TwoDimensionalVector bc = c.subtract(b);
    
            int crossProduct = ab.cross(bc);

            if(crossProduct != 0)
            {
                if(prevCrossProduct == null)
                {
                    prevCrossProduct = crossProduct;
                }
                else if(prevCrossProduct * crossProduct < 0)
                {
                    return false;
                }
            }
        }
        
        if(prevCrossProduct == null)
        {
            return false;
        }
        
        return true;
    }
    
}