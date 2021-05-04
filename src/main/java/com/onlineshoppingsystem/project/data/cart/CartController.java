package com.onlineshoppingsystem.project.data.cart;

import com.onlineshoppingsystem.project.data.cart.model.CartHTTPResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private final CartService cartService;

    @Autowired
    CartController(CartService cartService){
        this.cartService = cartService;
    }

//    @GetMapping("/cart/{id}")
//    public CartHTTPResponse getCart(@PathVariable long id){
//        return cartService.getCart(id);
//    }
    @GetMapping("/cart")
    public List<CartHTTPResponse> getAllCart(){
        return cartService.getAllCart();
    }


}
