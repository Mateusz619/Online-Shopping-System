package com.onlineshoppingsystem.project.data.cart;

import com.onlineshoppingsystem.project.data.cart.model.Cart;
import com.onlineshoppingsystem.project.data.cart.model.CartHTTPRequest;
import com.onlineshoppingsystem.project.data.cart.model.CartHTTPResponse;
import com.onlineshoppingsystem.project.data.cart.model.CartMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

@Service
public class CartService {

    private final CartRepository cartRepository;


    @Autowired
    CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public CartHTTPResponse getCart( long id){
        Cart cart = cartRepository.findById(id).get();
        CartHTTPResponse response = CartMapper.map(cart);
        return response;
    }

    public List<CartHTTPResponse> getAllCart() {
        return stream(cartRepository.findAll().spliterator(), false)
                .map(cart -> CartMapper.map(cart))
                .collect(Collectors.toList());
    }

    public String createCart(CartHTTPRequest cart){
        Cart cartEntity = CartMapper.map(cart);
        Cart saveCart = cartRepository.save(cartEntity);
        return String.valueOf(saveCart.getId());
    }

    public boolean deleteCart(long id){
        if(cartRepository.existsById(id)){
            cartRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public String updateCart(long id, CartHTTPRequest cart){
        Cart cartEntity = CartMapper.map(cart);
        cartEntity.setId(id);
        Cart save = cartRepository.save(cartEntity);
        return String.valueOf(save.getId());
    }

}
