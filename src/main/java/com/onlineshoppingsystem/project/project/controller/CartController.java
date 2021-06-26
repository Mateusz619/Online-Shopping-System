package com.onlineshoppingsystem.project.project.controller;

import com.onlineshoppingsystem.project.model.CartHTTPResponse;
import com.onlineshoppingsystem.project.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(value = "/cart/get")
    public List<CartHTTPResponse> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping(value = "/cart/get/{id}")
    public CartHTTPResponse getCartById(@PathVariable long id) {
        return cartService.getCartById(id);
    }

    @PostMapping(value = "/cart/save")
    public long saveCart() {
        return cartService.saveCart();
    }

    @PutMapping(value = "/cart/update/{cartId}/product/{productId}")
    public long updateCart(@PathVariable long cartId, @PathVariable long productId) {
        return cartService.updateCart(cartId, productId);
    }

    @DeleteMapping(value = "/cart/delete/{cartId}/product/{productId}")
    public Optional<Object> deleteProductById(@PathVariable long cartId, @PathVariable long productId) {
        return cartService.deleteProduct(cartId, productId);
    }
}
