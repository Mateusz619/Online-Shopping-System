package com.onlineshoppingsystem.project.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "cart")
@Getter
@Setter
@RestController
public class Cart {

    @OneToOne
    @JoinColumn
    private Product product;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String addToCart;
    private String removeFromCart;
    private String displayCart;


    public Cart(Product product, String addToCart, String removeFromCart, String displayCart) {
        this.product = product;
        this.addToCart = addToCart;
        this.removeFromCart = removeFromCart;
        this.displayCart = displayCart;
    }

    public Cart() {
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
            Cart cart = new Cart();
            cart.setId(id);
            cart.setProduct(product);
            return cart;
        }
    }
    private class ProductInCart {
        private List<String> productInCarts;

        public ProductInCart() {
            productInCarts = new ArrayList<>();
            productInCarts.add(1,"green");

        }
    }



}


