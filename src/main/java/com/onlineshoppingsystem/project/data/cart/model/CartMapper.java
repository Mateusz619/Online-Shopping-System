package com.onlineshoppingsystem.project.data.cart.model;

public class CartMapper {
    public static CartHTTPResponse map(Cart cart){
        return CartHTTPResponse.builder()
                .quantity(cart.getQuantity())
                .total(cart.getTotal())
                .products(cart.getProducts())
                .id(cart.getId())
                .build();
    }
    public static Cart map(CartHTTPRequest cart){
        return Cart.builder()
                .quantity(cart.getQuantity())
                .total(cart.getTotal())
                .products(cart.getProducts())
                .id(cart.getId())
                .build();
    }
}
