package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import java.io.File;


public class ShapeBuilderTest {
<<<<<<< HEAD
    
    // @Test
    // public void test_buildCircle() {
    //     ShapeParser sp = new ShapeParser(new File("C:/Users/GKY/Desktop/assigment/posd2024f_ta/src/resource/test.txt"));
    //     sp.parse();
    //     List<Shape> shapes = sp.getResult();
    //     for(Shape shape : shapes) {
    //         // System.out.println(shape.area());
    //     }
    // }

    // @Test
    // public void test_buildRectangle() {
    //     ShapeParser sp = new ShapeParser(new File("C:/Users/GKY/Desktop/assigment/posd2024f_ta/src/resource/test.txt"));
    //     sp.parse();
    //     List<Shape> shapes = sp.getResult();
    //     for(Shape shape : shapes) {
    //         if(shape instanceof TextedShape) {
    //             TextedShape textedShape = (TextedShape) shape;
    //             // System.out.println(textedShape.getText());
    //             ColoredShape coloredShape = (ColoredShape) textedShape.getShape();
    //             // System.out.println(coloredShape.getColor());
    //         }
    //     }
    // }

    // @Test
    // public void test_buildTriangle() {
    //     // Triangle [4,0] [4,3] [0,3], color=red, text=hello
    //     ShapeParser sp = new ShapeParser(new File("src\\resource\\test.txt"));
    //     sp.parse();
    //     List<Shape> shapes = sp.getResult();
    //     for(Shape shape : shapes) {
    //         // System.out.println("i am here");
    //         if(shape instanceof TextedShape) {
    //             // System.out.println(shape.area());
    //             TextedShape textedShape = (TextedShape) shape;
    //             System.out.println(textedShape.getText());
    //             ColoredShape coloredShape = (ColoredShape) textedShape.getShape();
    //             System.out.println(coloredShape.getColor());
    //         }
    //     }
    // }

    // @Test
    // public void test_buildCompoundShpae()
    // {
    //     ShapeParser sp = new ShapeParser(new File("src\\resource\\test.txt"));
    //     sp.parse();
    //     List<Shape> shapes = sp.getResult();
    //     System.out.println("shape size: "+shapes.size());
    //     System.out.println("shape's class"+shapes.get(0).getClass());
    //     for(Shape shape : shapes) {
    //         if(shape instanceof CompoundShape) {
    //             CompoundShape compoundShape = (CompoundShape) shape;

    //             // TextedShape textedShape = (TextedShape) shape;
    //             // System.out.println(textedShape.getText());
    //             // ColoredShape coloredShape = (ColoredShape) textedShape.getShape();
    //             // System.out.println(coloredShape.getColor());

    //             System.out.println("compound shape size: "+compoundShape.getShapes().size());  

    //             for(Shape s : compoundShape.getShapes()) {
    //                 if(s instanceof TextedShape) {
    //                     TextedShape textedShape = (TextedShape) s;
    //                     System.out.println(textedShape.getText());
    //                     ColoredShape coloredShape = (ColoredShape) textedShape.getShape();
    //                     System.out.println(coloredShape.getColor());
    //                 }
    //             }
    //         }
    //     }
    // }


    // @Test
    // public void test_nestedCompoundShape()
    // {
    //     ShapeParser sp = new ShapeParser(new File("src\\resource\\test.txt"));
    //     sp.parse();
    //     List<Shape> shapes = sp.getResult();
    //     System.out.println("test start");
    //     // System.out.println("shape size: "+shapes.size());
    //     // System.out.println("shape's class"+shapes.get(0).getClass());
    //     for (Shape shape : shapes) {
    //         if (shape instanceof CompoundShape) {
    //             CompoundShape compoundShape = (CompoundShape) shape;
    //             System.out.println("compound shape size: "+compoundShape.getShapes().size());
    //             for (Shape s : compoundShape.getShapes()) {
    //                 System.out.println(s.getClass());
    //                 if (s instanceof CompoundShape)
    //                 {
    //                     Shape ss = ((CompoundShape)s).getShapes().get(0);
    //                     System.out.println(ss.getClass());
    //                 }
    //             }
    //         }
    //     }
    // }
=======

    @Test
    public void test_buildCircle() {
        ShapeBuilder sb = new ShapeBuilder();
        sb.buildCircle(1.0, "red", "hello");
        List<Shape> shapes = sb.getResult();
        assertEquals(1, shapes.size());
        assertEquals(Math.PI * 1.0 * 1.0, shapes.get(0).area());
    }

    @Test
    public void test_buildRectangle()
    {
        ShapeBuilder sb = new ShapeBuilder();
        sb.buildRectangle(1.0, 2.0, "red", "hello");
        List<Shape> shapes = sb.getResult();
        assertEquals(1, shapes.size());
        assertEquals(1.0 * 2.0, shapes.get(0).area());
    }

    @Test
    public void test_buildTriangle()
    {
        ShapeBuilder sb = new ShapeBuilder();
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(4, 0));
        sb.buildTriangle(vectors, "red", "hello");
        List<Shape> shapes = sb.getResult();
        assertEquals(1, shapes.size());
        assertEquals(6.0, shapes.get(0).area());
    }

    @Test
    public void test_buildConvexPolygon()
    {
        ShapeBuilder sb = new ShapeBuilder();
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(4, 0));
        sb.buildConvexPolygon(vectors, "red", "hello");
        List<Shape> shapes = sb.getResult();
        assertEquals(1, shapes.size());
        assertEquals(12.0, shapes.get(0).area());
    }

    @Test
    public void test_buildCompoundShpae()
    {
        ShapeBuilder sb = new ShapeBuilder();
        sb.beginBuildCompoundShape(null, null);
        sb.buildCircle(1.0, null, null);
        sb.buildRectangle(1.0, 2.0, null, null);
        sb.endBuildCompoundShape();
        List<Shape> shapes = sb.getResult();
        List<Shape> innerShapes = ((CompoundShape)shapes.get(0)).getShapes();
        assertEquals(1, shapes.size());
        assertEquals(1.0 * 2.0 + Math.PI * 1.0 * 1.0, shapes.get(0).area());
        assertEquals(2, innerShapes.size());
        assertEquals(innerShapes.get(0).getClass(), Circle.class);
        assertEquals(innerShapes.get(1).getClass(), Rectangle.class);
    }

    @Test
    public void test_beginBuildCompoundShape()
    {
        ShapeBuilder sb = new ShapeBuilder();
        sb.beginBuildCompoundShape("red", "hello");
        List<Shape> shapes = sb.csList;
        assertEquals(1, shapes.size());
        sb.endBuildCompoundShape();
    }

    @Test
    public void test_endBuildCompoundShape()
    {
        ShapeBuilder sb = new ShapeBuilder();
        sb.beginBuildCompoundShape("red", "hello");
        List<Shape> shapes = sb.csList;
        assertEquals(1, shapes.size());
        sb.endBuildCompoundShape();
        assertEquals(0, shapes.size());
    }

    @Test
    public void test_colorShape()
    {
        ShapeBuilder sb = new ShapeBuilder();
        sb.buildCircle(1.0, "RED", null);
        List<Shape> shapes = sb.getResult();
        assertEquals(1, shapes.size());
        assertEquals("RED", ((ColoredShape)shapes.get(0)).getColor());
    }

    @Test
    public void test_textedShape()
    {
        ShapeBuilder sb = new ShapeBuilder();
        sb.buildCircle(1.0, null, "hello");
        List<Shape> shapes = sb.getResult();
        assertEquals(1, shapes.size());
        assertEquals("hello", ((TextedShape)shapes.get(0)).getText());
    }

    @Test
    public void teset_textedColoredShape()
    {
        ShapeBuilder sb = new ShapeBuilder();
        sb.buildCircle(1.0, "RED", "hello");
        List<Shape> shapes = sb.getResult();
        assertEquals(1, shapes.size());
        assertEquals("RED", ((ColoredShape)((TextedShape)shapes.get(0)).getShape()).getColor());
        assertEquals("hello", ((TextedShape)shapes.get(0)).getText());
    }

    @Test
    public void test_emptyCompoundShpae()
    {
        ShapeBuilder sb = new ShapeBuilder();
        sb.beginBuildCompoundShape(null, null);
        sb.endBuildCompoundShape();
        List<Shape> shapes = sb.getResult();
        assertEquals(1, shapes.size());
        shapes = ((CompoundShape)shapes.get(0)).getShapes();
        assertEquals(0, shapes.size());
    }

    
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
}
