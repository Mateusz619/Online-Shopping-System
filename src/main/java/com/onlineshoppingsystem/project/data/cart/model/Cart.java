package com.onlineshoppingsystem.project.data.cart.model;

import com.onlineshoppingsystem.project.data.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "cart")
@Getter
@Setter

public class Cart {

    @OneToOne
    @JoinColumn
    private Product product;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Cart( Product product) {
        this.product.equals(product);

    }
    public static CartBuilder builder() {
        return new CartBuilder();
    }

    public static final class CartBuilder {
        private Product product;
        private long id;

        private CartBuilder() {
        }

        public CartBuilder product(Product product) {
            this.product = product;
            return this;
        }

        public CartBuilder id(long id) {
            this.id = id;
            return this;
        }

        public Cart build() {
            Cart cart = new Cart(product);
            cart.setId(id);
            return cart;
        }
    }
}

