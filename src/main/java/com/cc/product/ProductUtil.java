package com.cc.product;

import java.util.HashSet;
import java.util.Set;

public class ProductUtil {

    private Set<Product> products;


    public ProductUtil() {
        products = new HashSet<Product>();
    }

    public boolean addProduct(Character SKUId, int price){
       return products.add(new Product(SKUId,price));
    }

    public Product getProduct(Character SKUId){
        return products.stream().filter(p-> p.equals(new Product(SKUId,0))).findAny().orElse(null);
    }

    @Override
    public String toString() {
        return "ProductUtil{" +
                "products=" + products +
                '}';
    }
}
