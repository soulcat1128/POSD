package org.ntut.posd2024f.midterm;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class BundleTest {
    @Test
    public void testBunble() throws Exception
    {
        Bundle b = new Bundle("test");
        assertEquals(b.getTitle(), "test");
    }

    @Test
    public void testBadd()
    {
        Bundle b = new Bundle("test");
        Book t = new Book("123", 1);
        b.add(t);
        assertEquals(b.iterator().next(), t);
    }
}
