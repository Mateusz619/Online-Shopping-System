package com.onlineshoppingsystem.project.data.cart.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartHTTPRequest {
    private int quantity;
    private float total;
    private String products;
    private int id;

    public CartHTTPRequest(int quantity, float total, String products, int id) {
        this.quantity = quantity;
        this.total = total;
        this.products = products;
        this.id = id;
    }


}
