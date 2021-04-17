package com.onlineshoppingsystem.project.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cart")
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;
    private double total;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Cart(int quantity, double total, Product product) {
        this.quantity = quantity;
        this.total = total;
        this.product = product;
    }
