package org.ntut.posd2024f.shapes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ShapeParser {
    
    private ShapeBuilder shapeBuilder = new ShapeBuilder();
<<<<<<< HEAD
    // private List<Shape> temp = new ArrayList<Shape>();
    private Scanner scanner;
    

    // 使用 scanner 讀取檔案
    public ShapeParser(File file) {
        System.out.println("start start start");
=======
    private Scanner scanner;
    public int count = 0;  // count the number of CompoundShape

    // 使用 scanner 讀取檔案
    public ShapeParser(File file) {
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            throw new RuntimeException("File not found");
        }
    }
    
    public void parse() {
        while(scanner.hasNext()) {
<<<<<<< HEAD
            String line = scanner.nextLine();
            System.out.println("line: " + line);
            if (line.startsWith("Circle")) {
                parseCircle(line,this.shapeBuilder);
            }
            else if (line.startsWith("Rectangle")) {
                parseRectangle(line, this.shapeBuilder);
            }
            else if (line.startsWith("Triangle")) {
                parseVectorShape(line, this.shapeBuilder);
            }
            else if (line.startsWith("ConvexPolygon")) {
                parseVectorShape(line, this.shapeBuilder);
            }
            else if (line.startsWith("CompoundShape")) {
                parseCompoundShape(line, this.shapeBuilder);
            }
        }
    }

    private void parseCircle(String line, ShapeBuilder shapeBuilder) {
        // System.out.println("line: " + line);
        // Circle radius=3.0, color=red, text=hello
=======
            String line = scanner.nextLine().trim();
            if (line.startsWith("Circle")) {
                parseCircle(line);
            }
            else if (line.startsWith("Rectangle")) {
                parseRectangle(line);
            }
            else if (line.startsWith("Triangle")) {
                parseVectorShape(line);
            }
            else if (line.startsWith("ConvexPolygon")) {
                parseVectorShape(line);
            }
            else if (line.startsWith("CompoundShape")) {
                parseCompoundShape(line);
            }
            if (line.contains("}")) {
                count--;
                shapeBuilder.endBuildCompoundShape();
            }
        }

        if (count != 0)
        {
            throw new IllegalArgumentException("Expected token '}'");
        }
    }

    private void parseCircle(String line) {
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
        String[] tokens = line.split(",");
        double radius = Double.parseDouble(tokens[0].split(" ")[1]);
        String color = null;
        String text = null;

        for(int i = 1; i < tokens.length; i++) {
            if (tokens[i].trim().startsWith("color=")) {
                color = tokens[i].split("=")[1];
            }
            else if (tokens[i].trim().startsWith("text=")) {
                text = tokens[i].split("=")[1];
            }
        }

        shapeBuilder.buildCircle(radius, color, text);
    }

<<<<<<< HEAD
    private void parseRectangle(String line, ShapeBuilder shapeBuilder)
    {
        // Rectangle 3.0 4.0, color=red, text=hello
        String[] tokens = line.split(",");
=======
    private void parseRectangle(String line)
    {
        String[] tokens = line.split(",");
        System.out.println("tokens");
        for (String token : tokens) {
            System.out.println(token);
        }
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
        double length = Double.parseDouble(tokens[0].split(" ")[1]);
        double width = Double.parseDouble(tokens[0].split(" ")[2]);
        String color = null;
        String text = null;

        for(int i = 1; i < tokens.length; i++) {
            if (tokens[i].trim().startsWith("color=")) {
                color = tokens[i].split("=")[1];
            }
            else if (tokens[i].trim().startsWith("text=")) {
                text = tokens[i].split("=")[1];
            }
        }

        shapeBuilder.buildRectangle(length, width, color, text);
    }

<<<<<<< HEAD
    private void parseVectorShape(String line, ShapeBuilder shapeBuilder)
=======
    private void parseVectorShape(String line)
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
    {
        // Triangle [4,0] [4,3] [0,3], color=red, text=hello you
        int n = 0;
        String[] tokens = null;
        if (line.contains("Triangle") ) {
            n = 3;
            tokens = line.replace("Triangle ", "").trim().split(", ");
        }
        else {
            n = 4;
            tokens = line.replace("ConvexPolygon ", "").trim().split(", ");
        }
<<<<<<< HEAD
        // System.out.println("tokens");
        // for (String token : tokens) {
        //     System.out.println(token);
        // }
        String[] vector = tokens[0].split(" ");
        // System.out.println("vector");
        // for (String v : vector) {
        //         System.out.println(v);
        //     }
=======
        String[] vector = tokens[0].split(" ");
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
        String color = null;
        String text = null;
        List<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        
        for(int i = 0; i < n; i++)
        {
            if (!vector[i].startsWith("["))
            {
                throw new IllegalArgumentException("Expected token '['");
            }
            if (!vector[i].endsWith("]"))
            {
                throw new IllegalArgumentException("Expected token ']'");
            }
            String[] point = vector[i].replace("[", "").replace("]", "").split(",");
            if (point.length != 2)
            {
                throw new IllegalArgumentException("Expected token ','");
            }
            int x = Integer.parseInt(point[0]);
            int y = Integer.parseInt(point[1]);
            vectors.add(new TwoDimensionalVector(x, y));
        }

        for(int i = 1; i < tokens.length; i++) {
            if (tokens[i].trim().startsWith("color=")) {
                color = tokens[i].split("=")[1];
            }
            else if (tokens[i].trim().startsWith("text=")) {
                text = tokens[i].split("=")[1];
            }
        }

        if (n == 4) {
            shapeBuilder.buildConvexPolygon(vectors, color, text);
        }
        else {
            shapeBuilder.buildTriangle(vectors, color, text);
        }
    }

<<<<<<< HEAD
    private void parseCompoundShape(String line, ShapeBuilder shapeBuilder) {
        System.out.println("start parseCompoundShape");
        String[ ] tokens = line.split(", ");
        // System.out.println("tokens");
        // for (String token : tokens) {
        //     System.out.println(token);
        // }
=======
    private void parseCompoundShape(String line) {
        String[ ] tokens = line.split(", ");
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
        if (!line.contains("{"))
        {
            throw new IllegalArgumentException("Expected token '{'");
        }
        String color = null;
        String text = null;
        if (tokens.length > 1)
        {
            for(int i = 1; i < tokens.length; i++) {
                if (tokens[i].trim().startsWith("color=")) {
                    color = tokens[i].split("=")[1];
                    if (i == tokens.length - 1)
                    {
                        String tmp = color.substring(color.length() - 2, color.length());
                        if (tmp.equals("{}"))
                        {
                            color = color.substring(0, color.length() - 3);
                        }
                        else
                        {
                            color = color.substring(0, color.length() - 2);
                        }
                    }
                }
                else if (tokens[i].trim().startsWith("text=")) {
                    text = tokens[i].split("=")[1];
<<<<<<< HEAD
                    // text.substring(0, text.length() - 1);
=======
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
                    String tmp = text.substring(text.length() - 2, text.length());
                    if (tmp.equals("{}"))
                    {
                        text = text.substring(0, text.length() - 3);
                    }
                    else
                    {
                        text = text.substring(0, text.length() - 2);
                    }
                }
            }
        }
<<<<<<< HEAD

        
        // System.out.println("color: " + color);
        // System.out.println("text: " + text);
        ShapeBuilder compoundShapeBuilder = new ShapeBuilder();
        compoundShapeBuilder.beginBuildCompoundShape(color, text);
        while(scanner.hasNext())
        {
            String lineString = scanner.nextLine();
            System.out.println("lineString: " + lineString);

            lineString = lineString.trim();
            // System.out.println("lineString: " + lineString);

            if (lineString.startsWith("Circle"))
            {
                parseCircle(lineString, compoundShapeBuilder);
            }
            else if (lineString.startsWith("Rectangle"))
            {
                parseRectangle(lineString, compoundShapeBuilder);
            }
            else if (lineString.startsWith("Triangle"))
            {
                parseVectorShape(lineString, compoundShapeBuilder);
            }
            else if (lineString.startsWith("ConvexPolygon"))
            {
                parseVectorShape(lineString, compoundShapeBuilder);
            }
            else if (lineString.startsWith("CompoundShape"))
            {
                parseCompoundShape(lineString, compoundShapeBuilder);
            }
            if (lineString.contains("}"))
            {
                System.out.println("break");
                break;
            }
        }
        // for(Shape shape : compoundShapeBuilder.getResult())
        // {
        //     // System.out.println("shape: " + shape);
        //     if (shape instanceof TextedShape)
        //     {
        //         TextedShape textedShape = (TextedShape) shape;
        //         System.out.println(textedShape.getText());
        //         ColoredShape coloredShape = (ColoredShape) textedShape.getShape();
        //         System.out.println(coloredShape.getColor());
        //     }
        // }
        compoundShapeBuilder.endBuildCompoundShape();
        shapeBuilder.shapes.add(compoundShapeBuilder.getResult().get(0));
        // shapeBuilder.add(compoundShapeBuilder.getResult());
    }
 
    public List<Shape> getResult() {
        System.out.println("getResult");
        System.out.println("shape size: "+shapeBuilder.getResult().size());
        for(Shape shape : shapeBuilder.getResult()) {
            if (shape instanceof CompoundShape) {
                CompoundShape compoundShape = (CompoundShape) shape;
                System.out.println("compound shape size: "+compoundShape.getShapes().size());
                for(Shape s : compoundShape.getShapes()) {
                    System.out.println("in this compound shape: "+s.getClass());
                }
            }
        }
        return shapeBuilder.getResult();
        // return shapes;
=======
        shapeBuilder.beginBuildCompoundShape(color, text);
        count++;
    }
 
    public List<Shape> getResult() {
        return shapeBuilder.getResult();
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
    }
}
