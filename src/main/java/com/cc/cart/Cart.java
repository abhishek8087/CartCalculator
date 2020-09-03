package com.cc.cart;

import com.cc.product.Product;
import com.cc.product.ProductUtil;
import com.cc.promotion.ActivePromos;
import com.cc.promotion.MultipleProductsPromo;
import com.cc.promotion.SingleProductPromo;

import java.util.Set;
import java.util.TreeSet;

public class Cart {

    Set<CartProduct> cartProducts;

    ProductUtil productUtil;
    ActivePromos activePromos;
    public Cart(ProductUtil productUtil, ActivePromos activePromos) {
        this.cartProducts = new TreeSet<>();
        this.productUtil = productUtil;
        this.activePromos = activePromos;
    }

    public boolean addToCart(Character SKUId , int quantity){
        if(productUtil.getProduct(SKUId) != null)
            return cartProducts.add(new CartProduct(quantity,productUtil.getProduct(SKUId)));

        return false;
    }

    public void getMultiplePromo(Character SKUId){
        boolean nextMatch = false;
        MultipleProductsPromo mp = null;
        for(CartProduct cp : cartProducts){
            if(cp.equals(new CartProduct(0, new Product(SKUId,0)))){
                nextMatch = true;
                continue;
            }

            if(nextMatch){
                mp =  activePromos.getMultiplePromo(SKUId,cp.getProduct().getSKUId());

                if(mp != null  && cp.getFinalPrice() >=0) {
                    CartProduct firstProd = cartProducts.stream().
                            filter(c->c.equals(new CartProduct(0, new Product(SKUId,0))))
                            .findAny().orElse(null);
                    final Character p = mp.getProduct2().getSKUId();
                    CartProduct secondProd =  cartProducts.stream().
                            filter(c->c.equals(new CartProduct(0, new Product(p,0))))
                            .findAny().orElse(null);
                    Product p1 = productUtil.getProduct(SKUId);
                    Product p2 = productUtil.getProduct(p);
                    firstProd.setFinalPrice(calculatePrice(mp.getPercentageDiscount() , (p1.getPrice() + p2.getPrice())));
                    secondProd.setFinalPrice(-1);
                    break;
                }
            }
        }


    }

    private  int calculatePrice(int percent, int price){
        double a = percent/100.00f;
        int finalPrice = (int) (a * price);
        return (int) (price-finalPrice);
    }



    public void calculateCart(){
        for (CartProduct cartProduct : cartProducts){
            Product currProduct = cartProduct.getProduct();
            SingleProductPromo singleProductPromo = activePromos.getSinglePromo(currProduct.getSKUId());
            if(singleProductPromo != null && cartProduct.getFinalPrice() >=0){
                int quant = singleProductPromo.getQuantity();
                int discountableQuantity = 0;
                int multiFactor = cartProduct.getQuantity() / quant;
                int totalPrice=0;
                if(multiFactor >0)
                {
                    if(multiFactor > 1) {
                        discountableQuantity = (cartProduct.getQuantity() % quant);
                    }

                    int price = calculatePrice(singleProductPromo.getPercentageDiscount(),
                            (singleProductPromo.getQuantity() * currProduct.getPrice()));

                    totalPrice += price * multiFactor;
                    totalPrice = totalPrice + (discountableQuantity * currProduct.getPrice());

                }else {
                    totalPrice = totalPrice + (currProduct.getPrice() * cartProduct.getQuantity());
                }
                cartProduct.setFinalPrice(totalPrice);
            }else {
                getMultiplePromo(currProduct.getSKUId());
            }


        }
    }



    @Override
    public String toString() {
        return "Cart{" +
                "cartProducts=" + cartProducts +
                '}' + "\n" + "cart Total = " + totalCartAmount();
    }

    public int totalCartAmount(){
        int total = 0;
        for(CartProduct cartProduct : cartProducts){
            if(cartProduct.getFinalPrice() >=0)
                total+=cartProduct.getFinalPrice();
        }
        return total;
    }
}
