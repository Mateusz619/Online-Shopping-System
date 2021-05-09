package com.onlineshoppingsystem.project.controller;

import com.onlineshoppingsystem.project.data.Cart;
import com.onlineshoppingsystem.project.repository.CartRepository;
import com.onlineshoppingsystem.project.service.CartService;
import com.onlineshoppingsystem.project.model.CartHTTPResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private final CartService cartService;

    @Autowired
    CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartHTTPResponse> getAllCart(){
        return cartService.getAllCart();
    }
    Iterable<Cart> allId = CartRepository.findAllById(Id);

}
