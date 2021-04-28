package com.onlineshoppingsystem.project.controller;

import com.onlineshoppingsystem.project.data.Product;
import model.ProductDTO;
import com.onlineshoppingsystem.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "product/{id}")
    public ResponseEntity getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> ResponseEntity.ok(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "products")
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @PostMapping(value = "products")
    public ResponseEntity saveProduct(@RequestBody ProductDTO productDTO) {
        Product product = new Product(productDTO.getType(), productDTO.getName(), productDTO.getPrice(), productDTO.getQuantity());
        return ResponseEntity.ok(productRepository.save(product));
    }
}
