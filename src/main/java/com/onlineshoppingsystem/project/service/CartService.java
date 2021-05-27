package com.onlineshoppingsystem.project.service;

import com.onlineshoppingsystem.project.data.Cart;
import com.onlineshoppingsystem.project.data.Product;
import com.onlineshoppingsystem.project.mapper.CartMapper;
import com.onlineshoppingsystem.project.mapper.ProductMapper;
import com.onlineshoppingsystem.project.model.CartHTTPResponse;
import com.onlineshoppingsystem.project.repository.CartRepository;
import com.onlineshoppingsystem.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public List<CartHTTPResponse> getAllCarts() {
        return stream(cartRepository.findAll().spliterator(), false)
                .map(CartMapper::map)
                .collect(Collectors.toList());
    }

    public CartHTTPResponse getCartById(long id) {
        return cartRepository.findById(id)
                .map(CartMapper::map)
                .orElseThrow();
    }

    public long saveCart() {
        Cart cart = new Cart(0, new ArrayList<>());
        return cartRepository.save(cart).getId();
    }

    public long updateCart(long cartId, long productId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        Optional<Product> product = productRepository.findById(productId);

        if (cart.isPresent()) {
            if (product.isPresent()){
                cart.get().getProduct().add(product.get());
                return cartRepository.save(cart.get()).getId();
            }
        }
        return 0;
    }

    public Optional<Object> deleteProduct(long cartId, long productId) {
        return cartRepository.findById(cartId)
                .map(cart -> cart.getProduct()
                        .stream()
                        .filter(product -> productId == product.getId())
                        .findFirst()
                        .map(product -> {
                            cart.getProduct().remove(product);
                            cartRepository.save(cart);
                            return cart;
                        }));
    }
}
