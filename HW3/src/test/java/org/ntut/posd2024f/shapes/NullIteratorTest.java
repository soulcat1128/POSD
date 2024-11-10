package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class NullIteratorTest {

    private NullIterator nullIterator;

    @BeforeEach
    public void setUp()
    {
        nullIterator = new NullIterator();
    }

    @Test
    public void testNullIteratorHasNext()
    {
        assertFalse(nullIterator.hasNext());
    }

    @Test
    public void testNullIteratorNext()
    {
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> nullIterator.next());
        assertEquals("Null iterator does not point to any element", exception.getMessage());
    }
}
