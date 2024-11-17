package org.ntut.posd2024f.midterm;

public interface ItemVisitor<T> {
    void visitBook(Book book);
    void visitBundle(Bundle bundle);
    void visitDiscountItem(DiscountItem discountItem);
    T getResult();
}
