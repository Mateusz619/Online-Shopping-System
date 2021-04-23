package com.onlineshoppingsystem.project.controller;

import com.onlineshoppingsystem.project.data.Product;
import com.onlineshoppingsystem.project.dto.ProductDTO;
import com.onlineshoppingsystem.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PutMapping(value = "product/{id}")
    public ResponseEntity updateProductById(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productRepository.findById(id)
                .map(product -> ResponseEntity.ok(saveProduct(product, productDTO)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private Product saveProduct(Product product, ProductDTO productDTO) {
        product.setType(productDTO.getType());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());

        return productRepository.save(product);
    }

    @DeleteMapping(value = "product/{id}")
    public ResponseEntity deleteProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            productRepository.delete(product.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
