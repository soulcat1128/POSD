package org.ntut.posd2024f.midterm;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ItemTest {

    @Test
    public void testInstance() throws Exception
    {
        Book a = new Book("test", 1);
        Bundle b = new Bundle("gg");
        assertTrue(a instanceof Item);
        assertTrue(b instanceof Item);
    }

}
