package com.onlineshoppingsystem.project.data.cart.model;

public class CartMapper {
    public static CartHTTPResponse map(Cart cart){
        return CartHTTPResponse.builder()
                .product(cart.getProduct())
                .id(cart.getId())
                .build();
    }

}
