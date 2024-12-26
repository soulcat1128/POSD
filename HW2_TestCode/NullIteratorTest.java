package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class NullIteratorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private NullIterator nullIterator;

    @Before
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
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Null iterator does not point to any element");
        nullIterator.next();
    }

}
