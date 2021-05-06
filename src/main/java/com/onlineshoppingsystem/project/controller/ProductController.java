package com.onlineshoppingsystem.project.controller;

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

    @GetMapping(value = "/product/{id}")
    public ProductHTTPResponse getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @GetMapping(value = "/products")
    public List<ProductHTTPResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(value = "/product")
    public void saveProduct(@RequestBody ProductHTTPRequest productHTTPRequest) {
        productService.saveProduct(productHTTPRequest);
    }

    @PutMapping(value = "/product/{id}")
    public void updateProductById(@PathVariable long id, @RequestBody ProductHTTPRequest productHTTPRequest) {
        productService.updateProductById(id, productHTTPRequest);
    }

    @DeleteMapping(value = "/product/{id}")
    public boolean deleteProductById(@PathVariable long id) {
        return productService.deleteProductById(id);
    }
}
