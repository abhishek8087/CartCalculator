package com.cc.test.cart;

import com.cc.cart.Cart;
import com.cc.product.ProductUtil;
import com.cc.promotion.ActivePromos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartTest {

    ProductUtil productUtil;
    ActivePromos activePromos;
    Cart cart;

    @Before
    public void setUp(){
        productUtil = new ProductUtil();
        productUtil.addProduct('A',30);
        productUtil.addProduct('B',50);
        activePromos = new ActivePromos(productUtil);
        cart = new Cart(productUtil,activePromos);
    }

    @Test
    public void addToCartTest(){
        Assert.assertTrue(cart.addToCart('A',5));
    }

    @Test
    public void addToCartTestFalse(){
        Assert.assertFalse(cart.addToCart('D',5));
    }

    @Test
    public void totalCartAmountTest(){
        Assert.assertNotNull(cart.totalCartAmount());
    }

}
