package org.ntut.posd2024f.midterm;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class NullIterator implements Iterator<Item>{
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Item next() {
        throw new NoSuchElementException("No more element.");
    }
}
