package org.ntut.posd2024f.midterm;

public class Book implements Item{
    private String name;
    private double price;

    public Book(String name, double price)
    {
        if (name.length() == 0)
        {
            throw new IllegalArgumentException("The book should have a title.");
        }
        if(name.isEmpty())
        {
            throw new IllegalArgumentException("The book should have a title.");
        }
        if(name.trim().length() == 0)
        {
            throw new IllegalArgumentException("The book should have a title.");

        }
        if (price < 0)
        {
            throw new IllegalArgumentException("The price should be greater than or equal to 0.");
        }
        this.name = name;
        this.price = price;
    }

    @Override
    public String getTitle() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public <T> void accept(ItemVisitor<T> visitor) {
        visitor.visitBook(this);
    }




}
