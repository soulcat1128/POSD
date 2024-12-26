package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TwoDimensionalVectorTest {

    private TwoDimensionalVector v1;
    private TwoDimensionalVector v2;
    private TwoDimensionalVector v3;

    @Before
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
        assertEquals(v4.x, 2.0, 0.01);
        assertEquals(v4.y, 8.0, 0.01);
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
}