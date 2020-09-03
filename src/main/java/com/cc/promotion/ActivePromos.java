package com.cc.promotion;

import com.cc.product.Product;
import com.cc.product.ProductUtil;

import java.util.*;

public class ActivePromos {

    Set<SingleProductPromo> singleProductPromos;
    Set<MultipleProductsPromo> multipleProductsPromos;
    ProductUtil productUtil;

    public ActivePromos(ProductUtil productUtil) {
        this.singleProductPromos = new HashSet<>();
        this.multipleProductsPromos = new HashSet<>();
        this.productUtil = productUtil;
    }

    public boolean addSinglePromo(Character SKUId, int quantity , int percentage){
        if(productUtil.getProduct(SKUId) != null)
            return singleProductPromos.add(new SingleProductPromo(quantity,productUtil.getProduct(SKUId),percentage));

        return false;
    }

    public boolean addMultiplePromo(Character SKUId, Character SKUId1, int percentage){
        if(productUtil.getProduct(SKUId) != null && productUtil.getProduct(SKUId1) != null)
            return  multipleProductsPromos.add(new MultipleProductsPromo(productUtil.getProduct(SKUId),
                productUtil.getProduct(SKUId1),percentage));

        return false;
    }


    public SingleProductPromo getSinglePromo(Character SKUId){
        return singleProductPromos.stream().filter(p->p.equals(new SingleProductPromo(0,new Product(SKUId,0),0))).findAny().orElse(null);
    }

    public MultipleProductsPromo getMultiplePromo(Character SKUId, Character SKUId1){
        return multipleProductsPromos.stream().filter(p->p.equals(new MultipleProductsPromo(new Product(SKUId,0),new Product(SKUId1,0),0)))
                .findAny().orElse(null);
    }


}
