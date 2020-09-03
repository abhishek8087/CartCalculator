package com.cc.test.promotion;

import com.cc.product.ProductUtil;
import com.cc.promotion.ActivePromos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActivePromosTest {


    ProductUtil productUtil;
    ActivePromos activePromos;

    @Before
    public void setUp(){
        productUtil = new ProductUtil();
        productUtil.addProduct('A',30);
        productUtil.addProduct('B',50);
        activePromos = new ActivePromos(productUtil);
    }

    @Test
    public void addSinglePromoTest(){

        Assert.assertTrue(activePromos.addSinglePromo('A',2,10));
    }

    @Test
    public void addMultiplePromoTest(){
        Assert.assertTrue(activePromos.addMultiplePromo('A','B',10));
    }

    @Test
    public void addMultiplePromoTestFalse(){
        Assert.assertFalse(activePromos.addMultiplePromo('A','D',10));
    }



}
