package org.ntut.posd2024f.shapes;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NullIterator implements Iterator<Shape> {
    @Override
    public boolean hasNext(){
        return false;
    }

    @Override
    public Shape next(){
        throw new NoSuchElementException("Null iterator does not point to any element");
    }
}
