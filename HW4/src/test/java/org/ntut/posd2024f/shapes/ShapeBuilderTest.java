package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import java.io.File;


public class ShapeBuilderTest {
    
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
}
