package org.ntut.posd2024f.shapes;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class PrettyPrintVisitor implements Visitor<String>{
    private StringBuilder result = new StringBuilder();
    private String countSpace = "";

    @Override
    public void visitCircle(Circle circle) {
        result.append(countSpace)
              .append("Circle ")
              .append(circle.getRadius());
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        result.append(countSpace)
              .append("Rectangle ")
              .append(rectangle.getLength())
              .append(" ")
              .append(rectangle.getWidth());
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        List<TwoDimensionalVector> vectors = triangle.getVectors();
        result.append(countSpace)
              .append("Triangle ");
        for (TwoDimensionalVector vector : vectors)
        {
            result.append(vector.toString())
                  .append(" ");
        }
        // 去多餘空白
        if ( result.length() > 0 && result.charAt(result.length() - 1) == ' ')
        {
            result.setLength(result.length() - 1);
        }
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
        List<TwoDimensionalVector> vectors = convexPolygon.getVectors();
        result.append(countSpace)
              .append("ConvexPolygon ");
        for (TwoDimensionalVector vector : vectors)
        {
            result.append(vector.toString())
                  .append(" ");
        }
        // 去多餘空白
        if ( result.length() > 0 && result.charAt(result.length() - 1) == ' ')
        {
            result.setLength(result.length() - 1);
        }
    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
        Iterator<Shape> it = compoundShape.iterator();
        if(!it.hasNext())
        {
            result.append(countSpace)
                  .append("CompoundShape {}");
            return;
        }
        result.append(countSpace)
              .append("CompoundShape {\n");
        this.countSpace += "  ";
        while (it.hasNext())
        {
            Shape shape = it.next();
            shape.accept(this);
            if(it.hasNext())
            {
                result.append("\n");
            }
        }
        this.countSpace = this.countSpace.substring(0, this.countSpace.length() - 2);
        result.append("\n")
              .append(this.countSpace)
              .append("}");
        }

    @Override
    public void visitTextedShape(TextedShape textedShape) {
        textedShape.getShape().accept(this);
        result.append(", text: ")
              .append(textedShape.getText());
    }

    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
        String color = coloredShape.getColor().toLowerCase();
        result.append(this.countSpace);
        if (color.equals("red"))
        {
            result.append("\033[0;31m");
        }
        else if (color.equals("green"))
        {
            result.append("\033[0;32m");
        }
        else if (color.equals("blue"))
        {
            result.append("\033[0;34m");
        }
        else
        {
            result.append(color);
        }
        int resultLength = this.result.length();
        Shape shape = coloredShape.getShape();
        shape.accept(this);
        // result.setLength(resultLength);
        String front = this.result.substring(0, resultLength);
        String back = this.result.substring(resultLength + this.countSpace.length());
        
        this.result.setLength(0);
        result.append(front)
              .append(back);
        result.append("\033[0m");
    }

    @Override
    public String getResult() {
        return this.result.toString();
    }
}
