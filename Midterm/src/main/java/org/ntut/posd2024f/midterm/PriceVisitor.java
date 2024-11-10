package org.ntut.posd2024f.midterm;

import java.util.Iterator;

public class PriceVisitor implements ItemVisitor<Double>{

    private Double price;
    private double dis = 1;

    public PriceVisitor() {

    }

    @Override
    public void visitBook(Book book) {
        if(dis != 1)
        {
            price += book.getPrice() * (1 - dis);
        }
        else
        {
            price += book.getPrice();
        }
        // dis = 1;
    }

    @Override
    public void visitBundle(Bundle bundle) {
        Iterator<Item> it = bundle.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            // check
            item.accept(this);
        }
        dis = 1;
    }

    @Override
    public void visitDiscountItem(DiscountItem discountItem) {
        Item item = discountItem.getItem();
        dis = discountItem.getDiscount();
        item.accept(this);
    }

    @Override
    public Double getResult() {
        return price;
    }
}
