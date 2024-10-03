package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public class NullIterator implements Iterator<Shape> {
    @Override
    public boolean hasNext(){
        return false;
    }

    @Override
    public Shape next(){
        return null;
    }
}
