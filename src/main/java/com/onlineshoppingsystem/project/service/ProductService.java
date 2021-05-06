package com.onlineshoppingsystem.project.service;

import com.onlineshoppingsystem.project.data.Product;
import com.onlineshoppingsystem.project.mapper.ProductMapper;
import com.onlineshoppingsystem.project.model.ProductHTTPRequest;
import com.onlineshoppingsystem.project.model.ProductHTTPResponse;
import com.onlineshoppingsystem.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductHTTPResponse getProductById(long id) {
        return productRepository.findById(id)
                .map(ProductMapper::map)
                .orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    public List<ProductHTTPResponse> getAllProducts() {
        return stream(productRepository.findAll().spliterator(),false)
                .map(ProductMapper::map)
                .collect(Collectors.toList());
    }

    public void saveProduct(ProductHTTPRequest productHTTPRequest) {
        Product product = ProductMapper.map(productHTTPRequest);
        productRepository.save(product);
    }

    public void updateProductById(long id, ProductHTTPRequest productHTTPRequest) {
        Product product = ProductMapper.map(productHTTPRequest);
        product.setId(id);
        productRepository.save(product);
    }

    public boolean deleteProductById(long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
