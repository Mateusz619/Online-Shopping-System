package com.onlineshoppingsystem.project.data;

import lombok.Data;

@Data
public class CartDTO {
    private int quantity;
    private float Total;
    private String products;
    private int id;

}
