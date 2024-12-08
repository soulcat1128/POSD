package org.ntut.posd2024f.shapes;

<<<<<<< HEAD
public class NullIteratorTest {
=======
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
>>>>>>> 920604d28246e7ecbdb0e8b23e65704e00302a24
}
