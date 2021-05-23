package com.onlineshoppingsystem.project.controller;

import com.onlineshoppingsystem.project.data.Product;
import com.onlineshoppingsystem.project.repository.ProductRepository;
import com.onlineshoppingsystem.project.model.ProductHTTPRequest;
import com.onlineshoppingsystem.project.model.ProductHTTPResponse;
import com.onlineshoppingsystem.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/get/product/{id}")
    public ProductHTTPResponse getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @GetMapping(value = "/get/products")
    public List<ProductHTTPResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(value = "/save/product")
    public long saveProduct(@RequestBody ProductHTTPRequest productHTTPRequest) {
        return productService.saveProduct(productHTTPRequest);
    }

    @PutMapping(value = "/update/product/{id}")
    public long updateProductById(@PathVariable long id, @RequestBody ProductHTTPRequest productHTTPRequest) {
        return productService.updateProductById(id, productHTTPRequest);
    }

    @DeleteMapping(value = "/delete/product/{id}")
    public boolean deleteProductById(@PathVariable long id) {
        return productService.deleteProductById(id);
    }
}