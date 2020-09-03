package com.cc.promotion;

import com.cc.product.Product;

public class SingleProductPromo {

    private int quantity;
    private Product product;
    private int percentageDiscount;


    public SingleProductPromo(int quantity, Product product, int percentageDiscount) {
        this.quantity = quantity;
        this.product = product;
        this.percentageDiscount = percentageDiscount;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

        SingleProductPromo that = (SingleProductPromo) o;

        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return product.hashCode();
    }
}
