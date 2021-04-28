package com.onlineshoppingsystem.project.data.cart;

import com.onlineshoppingsystem.project.data.cart.model.Cart;
import com.onlineshoppingsystem.project.data.cart.model.CartHTTPRequest;
import com.onlineshoppingsystem.project.data.cart.model.CartHTTPResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private final CartService cartService;

    @Autowired
    CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/cart/{id}")
    public CartHTTPResponse getCart(@PathVariable long id){
        return cartService.getCart(id);
    }
    @GetMapping
    public List<CartHTTPResponse> getAllCart(){
        return cartService.getAllCart();
    }
    @PostMapping("/cart")
    public String createCart(CartHTTPRequest request){
        return cartService.createCart(request);
    }
    @DeleteMapping("/cart/{id}")
    public boolean deleteCart(@PathVariable long id){
        return cartService.deleteCart(id);
    }
    @PutMapping("/cart/{id}")
    public String updateCart(@PathVariable  long id, CartHTTPRequest request){
        return cartService.updateCart(id, request);
    }

}
