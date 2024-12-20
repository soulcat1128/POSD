package org.ntut.posd2024f.shapes;

import java.util.List;
import java.util.ArrayList;

public class ShapeBuilder {

    public List<Shape> shapes = new ArrayList<Shape>();
<<<<<<< HEAD
    private List<Shape> temp = new ArrayList<Shape>();
    private List<Shape> csList = new ArrayList<Shape>();
    private int cs_index;
=======
    public List<Shape> csList = new ArrayList<Shape>();
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24

    public ShapeBuilder() {
    }
    
    public void buildCircle(double radius, String color, String text) {
<<<<<<< HEAD
        System.out.println("buildCircle");
        System.out.println("radius: "+radius);
        System.out.println("color: "+color);
        System.out.println("text: "+text);
=======
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
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
<<<<<<< HEAD
            temp.add(circle);
=======
            csList.get(csList.size()-1).add(circle);
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
        }
        else {
            shapes.add(circle);
        }
    }

    public void buildRectangle(double length, double width, String color, String text) {
<<<<<<< HEAD
        System.out.println("buildRectangle");
        System.out.println("length: "+length);
        System.out.println("width: "+width);
        System.out.println("color: "+color);
        System.out.println("text: "+text);

=======
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
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
<<<<<<< HEAD
            temp.add(rectangle);
=======
            csList.get(csList.size()-1).add(rectangle);
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
        }
        else {
            shapes.add(rectangle);
        }
    }

    public void buildTriangle(List<TwoDimensionalVector> vectors, String color, String text) {
<<<<<<< HEAD
        System.out.println("buildTriangle");
        // System.out.println("vectors: "+vectors);
        for(TwoDimensionalVector vector : vectors) {
            System.out.println("vector: "+vector);
        }
        System.out.println("color: "+color);
        System.out.println("text: "+text);
=======
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
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
<<<<<<< HEAD
            temp.add(triangle);
=======
            csList.get(csList.size()-1).add(triangle);
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
        }
        else {
            shapes.add(triangle);
        }
    }

    public void buildConvexPolygon(List<TwoDimensionalVector> vectors, String color, String text) {
<<<<<<< HEAD
        System.out.println("buildConvexPolygon");
        // System.out.println("vectors: "+vectors);
        for(TwoDimensionalVector vector : vectors) {
            System.out.println("vector: "+vector);
        }
        System.out.println("color: "+color);
        System.out.println("text: "+text);

=======
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
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
<<<<<<< HEAD
            temp.add(convexPolygon);
=======
            csList.get(csList.size()-1).add(convexPolygon);
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
        }
        else {
            shapes.add(convexPolygon);
        }
    }

    public void beginBuildCompoundShape(String color, String text) {    
<<<<<<< HEAD
        System.out.println("beginBuildCompoundShape");
        System.out.println("color: "+color);
        System.out.println("text: "+text);
=======
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
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
<<<<<<< HEAD
        cs_index = csList.size() - 1;

    }

    public void endBuildCompoundShape() {
        System.out.println("endBuildCompoundShape");
        if (temp.size() > 0)
        {
            for (Shape shape : temp) {
                ((CompoundShape)csList.get(cs_index)).add(shape);
            }
            temp.clear();
            if ()
        }
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
        
=======
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
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
        return shapes;
    }
}
