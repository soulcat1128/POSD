package org.ntut.posd2024f.shapes;

import java.util.List;
import java.util.ArrayList;

public class ShapeBuilder {

    public List<Shape> shapes = new ArrayList<Shape>();
    public List<Shape> csList = new ArrayList<Shape>();

    public ShapeBuilder() {
    }
    
    public void buildCircle(double radius, String color, String text) {
        Shape circle = new Circle(radius);
        if (color != null) {
            circle = new ColoredShape(circle, color);
            if (text != null) {
                circle = new TextedShape(circle, text);
            }
        }
        else if (text != null) {
            circle = new TextedShape(circle, text);
        }
        if (csList.size() > 0) {
            csList.get(csList.size()-1).add(circle);
        }
        else {
            shapes.add(circle);
        }
    }

    public void buildRectangle(double length, double width, String color, String text) {
        Shape rectangle = new Rectangle(length, width);
        if (color != null) {
            rectangle = new ColoredShape(rectangle, color);
            if (text != null) {
                rectangle = new TextedShape(rectangle, text);
            }
        }
        else if (text != null) {
            rectangle = new TextedShape(rectangle, text);
        }

        if (csList.size() > 0) {
            csList.get(csList.size()-1).add(rectangle);
        }
        else {
            shapes.add(rectangle);
        }
    }

    public void buildTriangle(List<TwoDimensionalVector> vectors, String color, String text) {
        Shape triangle = new Triangle(vectors);
        if (color != null) {
            triangle = new ColoredShape(triangle, color);
            if (text != null) {
                triangle = new TextedShape(triangle, text);
            }
        }
        else if (text != null) {
            triangle = new TextedShape(triangle, text);
        }

        if (csList.size() > 0) {
            csList.get(csList.size()-1).add(triangle);
        }
        else {
            shapes.add(triangle);
        }
    }

    public void buildConvexPolygon(List<TwoDimensionalVector> vectors, String color, String text) {
        Shape convexPolygon = new ConvexPolygon(vectors);
        if (color != null) {
            convexPolygon = new ColoredShape(convexPolygon, color);
            if (text != null) {
                convexPolygon = new TextedShape(convexPolygon, text);
            }
        }
        else if (text != null) {
            convexPolygon = new TextedShape(convexPolygon, text);
        }

        if (csList.size() > 0) {
            csList.get(csList.size()-1).add(convexPolygon);
        }
        else {
            shapes.add(convexPolygon);
        }
    }

    public void beginBuildCompoundShape(String color, String text) {    
        Shape compoundShape = new CompoundShape();
        if (color != null) {
            compoundShape = new ColoredShape(compoundShape, color);
            if (text != null) {
                compoundShape = new TextedShape(compoundShape, text);
            }
        }
        else if (text != null) {
            compoundShape = new TextedShape(compoundShape, text);
        }
        csList.add(compoundShape);
    }

    public void endBuildCompoundShape() {
        if (csList.size() > 1) {
            csList.get(csList.size() - 2).add(csList.get(csList.size() - 1));
            csList.remove(csList.size() - 1);
        }
        else {
            shapes.add(csList.get(0));
            csList.clear();
        }
        
    }

    public List<Shape> getResult() {
        return shapes;
    }
}
