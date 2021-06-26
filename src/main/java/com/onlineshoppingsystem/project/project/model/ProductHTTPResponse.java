package com.onlineshoppingsystem.project.project.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductHTTPResponse {
    private long id;
    private String type;
    private String name;
    private float price;

    public ProductHTTPResponse(long id, String type, String name, float price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public static ProductHTTPResponseBuilder builder() {
        return new ProductHTTPResponseBuilder();
    }

    public static final class ProductHTTPResponseBuilder {
        private long id;
        private String type;
        private String name;
        private float price;

        private ProductHTTPResponseBuilder() {
        }

        public ProductHTTPResponseBuilder id(long id) {
            this.id = id;
            return this;
        }

        public ProductHTTPResponseBuilder type(String type) {
            this.type = type;
            return this;
        }

        public ProductHTTPResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductHTTPResponseBuilder price(float price) {
            this.price = price;
            return this;
        }

        public ProductHTTPResponse build() {
            return new ProductHTTPResponse(id, type, name, price);
        }
    }
}
