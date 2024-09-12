package org.ntut.posd2024f.shapes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.concurrent.ExecutionException;

public class InputOutput {
    public InputOutput() {
    }

    public ArrayList<Shape> handleInput(String inputFileName) throws NumberFormatException, Exception {
        String filePath = "C:\\Users\\eva38\\Desktop\\樣式\\code\\posd2024f_ta-assignment1_template_code\\test_data\\input.txt";
        ArrayList<Shape> shapes = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String type = parts[0];
                
                switch (type) {
                    case "Circle":
                        try
                        {
                            if (parts.length == 2) {
                                double radius = Double.parseDouble(parts[1]);
                                shapes.add(new Circle(radius));
                            }
                        } catch (Exception e)
                        {
                            throw new NumberFormatException();
                        }
                        break;
                    case "Rectangle":
                        try {
                            if (parts.length == 3) {
                                double width = Double.parseDouble(parts[1]);
                                double height = Double.parseDouble(parts[2]);
                                shapes.add(new Rectangle(width, height));
                            }
                        } catch (Exception e) {
                            throw new Exception("It's not a rectangle!");
                        }
                        break;
                    case "Triangle":
                        try {
                            if (parts.length == 4) {
                                double side1 = Double.parseDouble(parts[1]);
                                double side2 = Double.parseDouble(parts[2]);
                                double side3 = Double.parseDouble(parts[3]);
                                shapes.add(new Triangle(side1, side2, side3));
                            }
                        } catch (Exception e) {
                            throw new Exception("It's not a triangle!");
                        }
                        break;
                    default:
                        System.out.println("Unknown shape type: " + type);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print all shapes to verify
        for (Object shape : shapes) {
            System.out.println(shape);
        }
        return shapes;
    }

    public ArrayList<Shape> handleSort(ArrayList<Shape> Shapes, String compare, String order) {
        switch (compare) {
            case "area":
                if(order == "inc")
                {
                    
                }
                else
                {

                }
                break;
            case "perimeter":

                break;
            default:
                break;
        }
    }

    public void handleOutput(ArrayList<Shape> Shapes, String outputFileName) {
    }

    private Shape ConstructShape(String str) throws NumberFormatException, Exception {
    }
}
