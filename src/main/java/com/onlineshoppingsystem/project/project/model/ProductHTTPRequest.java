package com.onlineshoppingsystem.project.project.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductHTTPRequest {
    private long id;
    private String type;
    private String name;
    private float price;

    public ProductHTTPRequest(long id, String type, String name, float price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public static ProductHTTPRequestBuilder builder() {
        return new ProductHTTPRequestBuilder();
    }

    public static final class ProductHTTPRequestBuilder {
        private long id;
        private String type;
        private String name;
        private float price;

        private ProductHTTPRequestBuilder() {
        }

        public ProductHTTPRequestBuilder id(long id) {
            this.id = id;
            return this;
        }

        public ProductHTTPRequestBuilder type(String type) {
            this.type = type;
            return this;
        }

        public ProductHTTPRequestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductHTTPRequestBuilder price(float price) {
            this.price = price;
            return this;
        }

        public ProductHTTPRequest build() {
            return new ProductHTTPRequest(id, type, name, price);
        }
    }
}
