package org.ntut.posd2024f.midterm;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class DiscountItemTest {
    @Test
    public void testConstruct()
    {
        Book a = new Book("test", 10);
        DiscountItem aa = new DiscountItem(a, 0.2);
        assertEquals(aa.getItem(), a);
        assertEquals(aa.getDiscount(), 0.2);
        assertEquals(aa.getTitle(), "<test> is on sale! 20% off!");
    }
}
