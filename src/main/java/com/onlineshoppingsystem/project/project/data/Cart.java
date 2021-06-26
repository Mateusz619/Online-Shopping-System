package com.onlineshoppingsystem.project.project.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "cart")
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double total;
    @ManyToMany
    @JoinColumn(name = "product_id")
    private List<Product> product;

    public Cart(double total, List<Product> product) {
        this.total = total;
        this.product = product;
    }
}
