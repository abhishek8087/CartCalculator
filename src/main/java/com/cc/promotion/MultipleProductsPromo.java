package com.cc.promotion;

import com.cc.product.Product;

public class MultipleProductsPromo {

    private Product product1;
    private Product product2;
    private int percentageDiscount;

    public MultipleProductsPromo(Product product1, Product product2, int percentageDiscount) {
        this.product1 = product1;
        this.product2 = product2;
        this.percentageDiscount = percentageDiscount;
    }

    public Product getProduct1() {
        return product1;
    }

    public void setProduct1(Product product1) {
        this.product1 = product1;
    }

    public Product getProduct2() {
        return product2;
    }

    public void setProduct2(Product product2) {
        this.product2 = product2;
    }

    public int getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(int percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MultipleProductsPromo that = (MultipleProductsPromo) o;

        if (!product1.equals(that.product1)) return false;
        return product2.equals(that.product2);
    }

    @Override
    public int hashCode() {
        int result = product1.hashCode();
        result = 31 * result + product2.hashCode();
        return result;
    }
}
