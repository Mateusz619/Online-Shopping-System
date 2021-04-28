package com.onlineshoppingsystem.project.data.cart.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quantity;
    private float total;
    private String products;
    private long id;

    public Cart(int quantity, float total, String products, long id) {
        this.quantity = quantity;
        this.total = total;
        this.products = products;
        this.id = id;
    }

    ArrayList<String> productsList = new ArrayList<String>(){
        {
            productsList.add("");
            productsList.add("");
            productsList.add("");
            productsList.add("");
            productsList.add("");
            productsList.add("");
            productsList.add("");
            productsList.add("");

        }
    };



}

