package com.onlineshoppingsystem.project.data;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @GetMapping(value = "cart/{id}")
    public ResponseEntity getCartById(@PathVariable Long id) {
        return cartRepository.findById(id)
                .map(cart -> ResponseEntity.ok(cart))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping(value = "cart")
    public ResponseEntity getAllCart() {
        return ResponseEntity.ok(cartRepository.findAll());
    }
    @GetMapping(value = "cart")
    public Iterable<Cart> cart1(){
        return cartRepository.findAll();
    }
    @GetMapping(value = "cart")
    public String numberOfProducts(@RequestParam List<String> products){
        return "Products are in cart" + products;
    }


    @PostMapping(value = "cart")
    public ResponseEntity saveCart(@RequestBody CartDTO cartDTO) {
        Cart cart = new Cart(cartDTO.getQuantity(), cartDTO.getTotal(), cartDTO.getPrducts(), cartDTO.getId());
        return ResponseEntity.ok(cartRepository.save(cart));
    }

}
