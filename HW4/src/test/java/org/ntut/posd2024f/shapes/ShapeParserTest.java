package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ShapeParserTest {
    

    @Test
    public void test_buildCircle() {
        String content = "Circle 3.0\n";
        File file = new File("output.txt");
        try (FileWriter writer = new FileWriter(file)) { 
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ShapeParser sp = new ShapeParser(new File("output.txt"));
        sp.parse();
        List<Shape> shapes = sp.getResult();
        assertEquals(shapes.get(0).getClass(), Circle.class);
    }

    @Test
    public void test_buildRectangle() {
        String content = "Rectangle 3.0 4.0\n";
        File file = new File("output.txt");
        try (FileWriter writer = new FileWriter(file)) { 
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ShapeParser sp = new ShapeParser(new File("output.txt"));
        sp.parse();
        List<Shape> shapes = sp.getResult();
        assertEquals(shapes.get(0).getClass(), Rectangle.class);
    }

    @Test
    public void test_buildVectorTriangle() {
        // Triangle [4,0] [4,3] [0,3], color=red, text=hello
        String content = "Triangle [4,0] [4,3] [0,3]\n";
        File file = new File("output.txt");
        try (FileWriter writer = new FileWriter(file)) { 
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ShapeParser sp = new ShapeParser(new File("output.txt"));
        sp.parse();
        List<Shape> shapes = sp.getResult();
        assertEquals(shapes.get(0).getClass(), Triangle.class);
    }

    @Test
    public void test_buildVectorConvexPolygon()
    {
        // ConvexPolygon [4,0] [4,3] [0,3] [0,0], color=red, text=hello
        String content = "ConvexPolygon [4,0] [4,3] [0,3] [0,0]\n";
        File file = new File("output.txt");
        try (FileWriter writer = new FileWriter(file)) { 
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ShapeParser sp = new ShapeParser(new File("output.txt"));
        sp.parse();
        List<Shape> shapes = sp.getResult();
        assertEquals(shapes.get(0).getClass(), ConvexPolygon.class);
    }

    @Test
    public void test_buildCompoundShape()
    {
        String content = "CompoundShape {\n";
        content += "  Circle 3.0\n";
        content += "}\n";
        File file = new File("output.txt");
        try (FileWriter writer = new FileWriter(file)) { 
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ShapeParser sp = new ShapeParser(new File("output.txt"));
        sp.parse();
        List<Shape> shapes = sp.getResult();
        assertEquals(shapes.get(0).getClass(), CompoundShape.class);
        Shape innerShape = ((CompoundShape)shapes.get(0)).getShapes().get(0);
        assertEquals(innerShape.getClass(), Circle.class);
    }

    @Test
    public void test_buildWithNonExistFile()
    {
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
        {
            ShapeParser sp = new ShapeParser(new File("Nonexist.txt"));
        });
        assertEquals(exception.getMessage(), "File not found");
    }

    @Test
    public void test_buildCompoundMissingLeftBraceThrowException()
    {
        String content = "CompoundShape\n";
        content += "  Circle 3.0\n";
        content += "}\n";
        File file = new File("output.txt");
        try (FileWriter writer = new FileWriter(file)) { 
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ShapeParser sp = new ShapeParser(new File("output.txt"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->
        {
            sp.parse();
        });
        assertEquals(exception.getMessage(), "Expected token '{'");
    }

    @Test
    public void test_buildCompoundMissingRightBraceThrowException()
    {
        String content = "CompoundShape {\n";
        content += "  Circle 3.0\n";
        content += "\n";
        File file = new File("output.txt");
        try (FileWriter writer = new FileWriter(file)) { 
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ShapeParser sp = new ShapeParser(new File("output.txt"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->
        {
            sp.parse();
        });
        assertEquals(exception.getMessage(), "Expected token '}'");
    }

    @Test
    public void test_buildTriangleMissingCommaThrowException()
    {
        String content = "Triangle [4,0] [43] [0,3]\n";
        File file = new File("output.txt");
        try (FileWriter writer = new FileWriter(file)) { 
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ShapeParser sp = new ShapeParser(new File("output.txt"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->
        {
            sp.parse();
        });
        assertEquals(exception.getMessage(), "Expected token ','");
    }

    @Test
    public void test_buildTriangleMissingLeftSquareBracketThrowException()
    {
        String content = "Triangle 4,0] [4,3] [0,3]\n";
        File file = new File("output.txt");
        try (FileWriter writer = new FileWriter(file)) { 
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ShapeParser sp = new ShapeParser(new File("output.txt"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->
        {
            sp.parse();
        });
        assertEquals(exception.getMessage(), "Expected token '['");
    }

    @Test
    public void test_buildTriangleMissingRightSquareBracketThrowException()
    {
        String content = "Triangle [4,0 [4,3] [0,3]\n";
        File file = new File("output.txt");
        try (FileWriter writer = new FileWriter(file)) { 
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ShapeParser sp = new ShapeParser(new File("output.txt"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->
        {
            sp.parse();
        });
        assertEquals(exception.getMessage(), "Expected token ']'");
    }
}
