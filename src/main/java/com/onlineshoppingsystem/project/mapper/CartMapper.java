package com.onlineshoppingsystem.project.mapper;

import com.onlineshoppingsystem.project.data.Cart;
import com.onlineshoppingsystem.project.model.CartHTTPResponse;

public class CartMapper {
    public static CartHTTPResponse map(Cart cart) {
        return CartHTTPResponse.builder()
                .id(cart.getId())
                .total(cart.getTotal())
                .product(cart.getProduct())
                .build();
    }
}
