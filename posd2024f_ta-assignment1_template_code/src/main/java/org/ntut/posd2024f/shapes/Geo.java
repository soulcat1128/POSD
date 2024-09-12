package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
public final class Geo {
    /**
     * @param args The arguments of the program.
     * @throws Exception
     * @throws NumberFormatException
     */
    public static void main(String[] args) throws NumberFormatException, Exception {
        InputOutput io = new InputOutput();        
        ArrayList<Shape> Shapes = io.handleInput(args[0]);
        Shapes = io.handleSort(Shapes, args[2], args[3]);
        io.handleOutput(Shapes, args[1]);
    }
}
