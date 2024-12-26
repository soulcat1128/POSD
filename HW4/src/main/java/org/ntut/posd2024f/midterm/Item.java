package org.ntut.posd2024f.midterm;

import java.util.Iterator;

public interface Item {
    public String getTitle();

    default void add(Item item) {
        throw new BookStoreException("Only bundle can add the item.");
    }

    default Iterator<Item> iterator() {
        return new NullIterator();
    }

    default Iterator<Item> dfsIterator() {
        return new DFSIterator(this);
    }
    
    public <T> void accept(ItemVisitor<T> visitor);
}
