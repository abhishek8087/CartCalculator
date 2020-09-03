package com.cc.test.product;

import com.cc.product.Product;
import com.cc.product.ProductUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductUtilTest {

    ProductUtil productUtil;

    @Before
    public void setUp(){
        productUtil = new ProductUtil();
        productUtil.addProduct('A',30);
        productUtil.addProduct('B',50);
    }

    @Test
    public void getProductTest(){
        Product prod = productUtil.getProduct('A');
        Assert.assertEquals(prod.getPrice(),30);
    }

    @Test
    public void addProductTest(){
        Assert.assertTrue(productUtil.addProduct('D',40));
    }

}
