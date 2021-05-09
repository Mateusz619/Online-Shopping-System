package com.onlineshoppingsystem.project.service;

import com.onlineshoppingsystem.project.model.CartHTTPResponse;
import com.onlineshoppingsystem.project.mapper.CartMapper;

import com.onlineshoppingsystem.project.model.ProductHTTPResponse;
import com.onlineshoppingsystem.project.repository.CartRepository;
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

    public List<CartHTTPResponse> getAllCart() {
        return stream(cartRepository.findAll().spliterator(), false)
                //.map(x-> CartMapper.map())
                .map(product -> CartMapper.map(product, ProductHTTPResponse.class))
                .collect(Collectors.toList());
    }

}
