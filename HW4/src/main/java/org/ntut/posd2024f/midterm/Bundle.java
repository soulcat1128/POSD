package org.ntut.posd2024f.midterm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bundle implements Item{
    private String title;
    public List<Item> bundles;

    public Bundle(String title) {
        if (title.length() == 0)
        {
            throw new IllegalArgumentException("The bundle should have a title.");
        }
        if (title.isEmpty())
        {
            throw new IllegalArgumentException("The bundle should have a title.");
        }
        if(title.trim().length() == 0)
        {
            throw new IllegalArgumentException("The bundle should have a title.");
        }
        this.title = title;
        bundles = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void add(Item item) {
        if(item != null)
        {
            bundles.add(item);
        }
    }

    @Override
    public <T> void accept(ItemVisitor<T> visitor) {
        visitor.visitBundle(this);
    }

    @Override
    public Iterator iterator() {
        return bundles.iterator();
    }
}
