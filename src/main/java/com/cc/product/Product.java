package com.cc.product;

public class Product {

    private char SKUId;
    private int price;

    public Product(char SKUId, int price) {
        this.SKUId = SKUId;
        this.price = price;
    }

    public char getSKUId() {
        return SKUId;
    }

    public void setSKUId(char SKUId) {
        this.SKUId = SKUId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return SKUId == product.SKUId;
    }

    @Override
    public int hashCode() {
        return SKUId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "SKUId=" + SKUId +
                ", price=" + price +
                '}';
    }
}
