package com.cc.runner;

import com.cc.cart.Cart;
import com.cc.cart.CartProduct;
import com.cc.product.ProductUtil;
import com.cc.promotion.ActivePromos;

public class Runner {

    public static void main(String[] args) {

        ProductUtil productUtil = new ProductUtil();
        productUtil.addProduct('A',30);
        productUtil.addProduct('B',40);
        productUtil.addProduct('C',60);
        productUtil.addProduct('D',10);

        ActivePromos ap = new ActivePromos(productUtil);
        ap.addSinglePromo('A',2,10);
        ap.addSinglePromo('B',3,2);
        ap.addMultiplePromo('C','D',5);

        Cart c = new Cart(productUtil,ap);
        c.addToCart('A',5);
        c.addToCart('B',6);
        c.addToCart('C',1);
        c.addToCart('D',1);

        c.calculateCart();

        System.out.println(c);

    }
}
