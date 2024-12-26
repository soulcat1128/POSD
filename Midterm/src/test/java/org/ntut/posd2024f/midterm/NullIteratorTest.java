package org.ntut.posd2024f.midterm;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;



import org.junit.jupiter.api.Test;
public class NullIteratorTest {

    @Test
    public void testNullIt()
    {
        Book b = new Book("test", 1);
        Iterator it = b.iterator();
        
        assertFalse(it.hasNext());
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            it.next();
        });
        assertEquals(exception.getMessage(), "No more element.");

    }
}
