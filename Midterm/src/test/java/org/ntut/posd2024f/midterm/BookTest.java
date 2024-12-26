package org.ntut.posd2024f.midterm;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class BookTest {    
    @Test
    public void testBook() throws Exception
    {
        Book b = new Book("test", 10);
        assertEquals(10, b.getPrice(), 0.01);
        assertEquals(b.getTitle(), "test");
    }

    @Test
    public void testBookAdd()
    {
        Book b = new Book("test", 1);
        
        BookStoreException exception = assertThrows(BookStoreException.class, () -> {
            b.add(new Book("123", 1));
        });
        assertEquals(exception.getMessage(), "Only bundle can add the item.");

    }


}
