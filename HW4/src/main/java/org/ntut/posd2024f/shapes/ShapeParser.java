package org.ntut.posd2024f.shapes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ShapeParser {
    
    private ShapeBuilder shapeBuilder = new ShapeBuilder();
    private Scanner scanner;
    public int count = 0;  // count the number of CompoundShape

    // 使用 scanner 讀取檔案
    public ShapeParser(File file) {
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            throw new RuntimeException("File not found");
        }
    }
    
    public void parse() {
        while(scanner.hasNext()) {
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

    private void parseRectangle(String line)
    {
        String[] tokens = line.split(",");
        System.out.println("tokens");
        for (String token : tokens) {
            System.out.println(token);
        }
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

    private void parseVectorShape(String line)
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
        String[] vector = tokens[0].split(" ");
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

    private void parseCompoundShape(String line) {
        String[ ] tokens = line.split(", ");
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
        shapeBuilder.beginBuildCompoundShape(color, text);
        count++;
    }
 
    public List<Shape> getResult() {
        return shapeBuilder.getResult();
    }
}
