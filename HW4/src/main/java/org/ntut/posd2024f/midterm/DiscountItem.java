package org.ntut.posd2024f.midterm;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DiscountItem implements Item{
    
    private Item item;
    private double discount;
    // private String title;
    // DecimalFormat Form;
    // private StringBuilder result = new StringBuilder();


    public DiscountItem(Item item, double discount) {
        if ( discount > 1 || discount < 0) {
            throw new IllegalArgumentException("The discount should be between 0 and 1.");
        }

        this.item = item;
        this.discount = discount;
    }

    public Item getItem() {
        return this.item;
    }

    public double getDiscount() {
        // result.append
        return this.discount;
    }

    @Override
    public String getTitle() {
        // int l = Form.format(getDiscount()*100).length();
        // String s = Form.format(getDiscount()*100).substring(0, l-2);


        DecimalFormat form = new DecimalFormat();

        return "<"+ getItem().getTitle() + ">" + " is on sale! " + form.format(getDiscount()*100) + "% off!";
    }

    @Override
    public <T> void accept(ItemVisitor<T> visitor) {
        visitor.visitDiscountItem(this);
    }
    
}
