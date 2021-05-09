package com.onlineshoppingsystem.project.mapper;

import com.onlineshoppingsystem.project.data.Cart;
import com.onlineshoppingsystem.project.model.CartHTTPResponse;
import com.onlineshoppingsystem.project.model.ProductHTTPResponse;

public class CartMapper {
    public static CartHTTPResponse map(Cart cart){
        return CartHTTPResponse.builder()
                .id(cart.getId())
                .product(cart.getProduct())
                .product(ProductHTTPResponse.builder()
                    .type(cart.getProduct().getType())
                    .name(cart.getProduct().getName())
                    .price(cart.getProduct().getPrice())
                    .build())
                .build();
    }
}
