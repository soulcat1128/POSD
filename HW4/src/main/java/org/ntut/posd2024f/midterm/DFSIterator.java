package org.ntut.posd2024f.midterm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class DFSIterator implements Iterator<Item>{
    
    private Item item = null;
    private List<List<Item>> bundles = new ArrayList<>() ;
    private int index = 0;
    private int deepIndex = 0;
    

    public DFSIterator(Item item) {
        if(item instanceof Book)
        {
            this.item = (Book)item;
            List<Item> items = new ArrayList<>();
            items.add(item);
            this.bundles.add(items);
        }
        else if (item instanceof Bundle)
        {
            this.bundles.add(((Bundle)item).bundles);
        }
    }

    public boolean hasNext() {
        if(index < bundles.size()) {
            return true;
        }
        return false;
    }

    public Item next()
    {
        if (index >= bundles.size() && deepIndex >= bundles.get(bundles.size()).size()) {
                throw new NoSuchElementException("No more element.");
            }
        if (deepIndex >= bundles.get(index).size())
        {
            deepIndex = 0;
            index ++;
            if (index >= bundles.size())
            {
                throw new NoSuchElementException("No more element.");
            }
            return bundles.get(index).get(deepIndex++);
        }
        else
        {
            return bundles.get(index).get(deepIndex++);
        }
    }
    
}
