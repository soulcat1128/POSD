package org.ntut.posd2024f.shapes;

import java.util.List;
import java.util.ArrayList;

public class ShapeBuilder {

    public List<Shape> shapes = new ArrayList<Shape>();
    private List<Shape> temp = new ArrayList<Shape>();
    private List<Shape> csList = new ArrayList<Shape>();
    private int cs_index;

    public ShapeBuilder() {
    }
    
    public void buildCircle(double radius, String color, String text) {
        System.out.println("buildCircle");
        System.out.println("radius: "+radius);
        System.out.println("color: "+color);
        System.out.println("text: "+text);
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
            temp.add(circle);
        }
        else {
            shapes.add(circle);
        }
    }

    public void buildRectangle(double length, double width, String color, String text) {
        System.out.println("buildRectangle");
        System.out.println("length: "+length);
        System.out.println("width: "+width);
        System.out.println("color: "+color);
        System.out.println("text: "+text);

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
            temp.add(rectangle);
        }
        else {
            shapes.add(rectangle);
        }
    }

    public void buildTriangle(List<TwoDimensionalVector> vectors, String color, String text) {
        System.out.println("buildTriangle");
        // System.out.println("vectors: "+vectors);
        for(TwoDimensionalVector vector : vectors) {
            System.out.println("vector: "+vector);
        }
        System.out.println("color: "+color);
        System.out.println("text: "+text);
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
            temp.add(triangle);
        }
        else {
            shapes.add(triangle);
        }
    }

    public void buildConvexPolygon(List<TwoDimensionalVector> vectors, String color, String text) {
        System.out.println("buildConvexPolygon");
        // System.out.println("vectors: "+vectors);
        for(TwoDimensionalVector vector : vectors) {
            System.out.println("vector: "+vector);
        }
        System.out.println("color: "+color);
        System.out.println("text: "+text);

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
            temp.add(convexPolygon);
        }
        else {
            shapes.add(convexPolygon);
        }
    }

    public void beginBuildCompoundShape(String color, String text) {    
        System.out.println("beginBuildCompoundShape");
        System.out.println("color: "+color);
        System.out.println("text: "+text);
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

        // cs_index = csList.size() - 1;
    }

    public void endBuildCompoundShape() {
        
        // 把 cs_index 的 compound shape, 從後面開始直到 cs_index + 1, 依序加入到 cs_index 的 compound shape 裡, 並且移除已經被加入到 compound shape 裡的 shape
        for (int i = 0; i < temp.size() ; i++) {
            ((CompoundShape)csList.get(csList.size()-1)).add(temp.get(i));
        }
        temp.clear();
        if (csList.size() > 1) {
            temp.add(csList.get(cs_index));
            csList.remove(csList.size() - 1);
        }
        else {
            shapes.add(csList.get(0));
            csList.clear();
        }
        
        System.out.println("endBuildCompoundShape");
    }

    public List<Shape> getResult() {
        for (Shape shape : shapes) {
            if (shape instanceof CompoundShape) {
                CompoundShape compoundShape = (CompoundShape) shape;
                System.out.println("compound shape size: "+compoundShape.getShapes().size());
                for (Shape s : compoundShape.getShapes()) {
                    System.out.println(s.getClass());
                    if (s instanceof CompoundShape)
                    {
                        Shape ss = ((CompoundShape)s).getShapes().get(0);
                        System.out.println("inner"+ss.getClass());
                    }
                }
            }
        }
        
        return shapes;
    }
}
