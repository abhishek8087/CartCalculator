package com.cc.cart;

import com.cc.product.Product;


public class CartProduct implements Comparable {

    private int quantity;
    private Product product;
    private int finalPrice;

    public CartProduct(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        this.finalPrice = 0;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartProduct that = (CartProduct) o;

        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return product.hashCode();
    }


    @Override
    public int compareTo(Object o) {

        CartProduct cp = (CartProduct) o;
        return this.product.hashCode() - cp.product.hashCode();
    }

    @Override
    public String toString() {
        return "\nCartProduct{" +
                "quantity=" + quantity +
                ", SKUID=" + product.getSKUId() +
                ", finalPrice=" + finalPrice +
                '}'+"\n";
    }


}
