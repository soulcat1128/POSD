package org.ntut.posd2024f.shapes;

<<<<<<< HEAD
public class TwoDimensionalVectorTest {
=======
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoDimensionalVectorTest {
    
    private TwoDimensionalVector v1;
    private TwoDimensionalVector v2;
    private TwoDimensionalVector v3;

    @BeforeEach
    public void setUp() throws Exception
    {
        v1 = new TwoDimensionalVector(3, 4);
        v2 = new TwoDimensionalVector(5, 12);
        v3 = new TwoDimensionalVector(7, 24);
    }

    @Test
    public void testVectorDot(){
        assertEquals(63.0, v1.dot(v2), 0.01);
        assertEquals(117.0, v1.dot(v3), 0.01);
        assertEquals(323.0, v2.dot(v3), 0.01);
    }

    @Test
    public void testVectorCross(){
        assertEquals(16.0, v1.cross(v2), 0.01);
        assertEquals(44.0, v1.cross(v3), 0.01);
        assertEquals(36.0, v2.cross(v3), 0.01);
    }

    @Test
    public void testVectorLength(){
        assertEquals(5.0, v1.length(), 0.01);
        assertEquals(13.0, v2.length(), 0.01);
        assertEquals(25.0, v3.length(), 0.01);
    }

    @Test
    public void testVectorSubtract()
    {
        TwoDimensionalVector v4 = v2.subtract(v1);
        assertEquals(v4.length(), Math.sqrt(68), 0.01);
        assertEquals(v4.getX(), 2.0, 0.01);
        assertEquals(v4.getY(), 8.0, 0.01);
    }

    @Test
    public void testVerticalVector()
    {
        TwoDimensionalVector v4 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector v5 = new TwoDimensionalVector(0, 3);

        assertEquals(9.0, v4.cross(v5), 0.01);
        assertEquals(0.0, v4.dot(v5), 0.01);
    }

    @Test
    public void testParallelVector()
    {
        TwoDimensionalVector v4 = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector v5 = new TwoDimensionalVector(6, 0);

        assertEquals(0.0, v4.cross(v5), 0.01);
        assertEquals(18.0, v4.dot(v5), 0.01);
    }

    @Test
    public void testVectorGetXY()
    {
        assertEquals(3, v1.getX());
        assertEquals(4, v1.getY());
        assertEquals(5, v2.getX());
        assertEquals(12, v2.getY());
        assertEquals(7, v3.getX());
        assertEquals(24, v3.getY());
    }
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
}