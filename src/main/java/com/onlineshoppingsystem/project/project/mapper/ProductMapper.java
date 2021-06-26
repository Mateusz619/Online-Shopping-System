package com.onlineshoppingsystem.project.project.mapper;

import com.onlineshoppingsystem.project.data.Product;
import com.onlineshoppingsystem.project.model.ProductHTTPRequest;
import com.onlineshoppingsystem.project.model.ProductHTTPResponse;

public class ProductMapper {
    public static ProductHTTPResponse map(Product product) {
        return ProductHTTPResponse.builder()
                .id(product.getId())
                .type(product.getType())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public static Product map(ProductHTTPRequest productHTTPRequest) {
        return Product.builder()
                .type(productHTTPRequest.getType())
                .name(productHTTPRequest.getName())
                .price(productHTTPRequest.getPrice())
                .build();
    }
}
