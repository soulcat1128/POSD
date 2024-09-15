package org.ntut.posd2024f.shapes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.security.CodeSigner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import javax.swing.text.NumberFormatter;

public class InputOutput {
    public InputOutput() {
    }

    public ArrayList<Shape> handleInput(String inputFileName) throws NumberFormatException, Exception {
        String filePath = inputFileName;
        ArrayList<Shape> shapes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Shape correctGraphic = ConstructShape(line);
                if (correctGraphic != null)
                {
                    shapes.add(correctGraphic);
                }
            }
        } catch (IOException e) {
            throw e;
        }
        return shapes;
    }

    public ArrayList<Shape> handleSort(ArrayList<Shape> Shapes, String compare, String order) {
        if (Shapes == null || compare == null || order == null)
        {
            throw new IllegalArgumentException();
        }
        switch (compare) {
            case "area":
                if (order.equals("inc"))
                {
                    Collections.sort(Shapes, Sort.BY_AREA_ASCENDING);
                }
                else if(order.equals("dec"))
                {
                    Collections.sort(Shapes, Sort.BY_AREA_DESCENDING);
                }
                break;
            case "perimeter":
                if (order.equals("inc"))
                {
                    Collections.sort(Shapes, Sort.BY_PERIMETER_ASCENDING);
                }
                else if(order.equals("dec"))
                {
                    Collections.sort(Shapes, Sort.BY_PERIMETER_DESCENDING);
                }
        }
        return Shapes;
    }

    public void handleOutput(ArrayList<Shape> Shapes, String outputFileName) {
        String filePath = outputFileName;
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath)))
        {
            for(Shape item : Shapes)      
            {
                writer.println(item.toString());
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private Shape ConstructShape(String str) throws NumberFormatException, Exception {
        String[] parts = str.split(" ");
        String type = parts[0];
        double arg1, arg2, arg3; // Circle: arg1 -> radius, Rectangle: arg1 -> length, arg2 -> width, Triangle: arg(1,2,3) -> side(1,2,3)
        switch (type) {
            case "Circle":
                if (parts.length == 2)
                {
                    arg1 = Double.parseDouble(parts[1]);
                    return new Circle(arg1);
                }
                break;
            case "Rectangle":
                if (parts.length == 3) {
                    arg1 = Double.parseDouble(parts[1]);
                    arg2 = Double.parseDouble(parts[2]);   
                    return new Rectangle(arg1, arg2);
                }
                break;
            case "Triangle":
                if(parts.length == 4)
                {
                    arg1 = Double.parseDouble(parts[1]);
                    arg2 = Double.parseDouble(parts[2]);
                    arg3 = Double.parseDouble(parts[3]);
                    return new Triangle(arg1, arg2, arg3);                    
                }
                break;
        }    
        return null;
    }
}
