package com.onlineshoppingsystem.project.model;

import com.onlineshoppingsystem.project.data.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartHTTPResponse {
    private long id;
    private double total;
    private List<Product> product;

    public CartHTTPResponse(long id, double total, List<Product> product) {
        this.id = id;
        this.total = total;
        this.product = product;
    }

    public static CartHTTPResponseBuilder builder() {
        return new CartHTTPResponseBuilder();
    }

    public static final class CartHTTPResponseBuilder {
        private long id;
        private double total;
        private List<Product> product;

        private CartHTTPResponseBuilder() {
        }

        public CartHTTPResponseBuilder id(long id) {
            this.id = id;
            return this;
        }

        public CartHTTPResponseBuilder total(double total) {
            this.total = total;
            return this;
        }

        public CartHTTPResponseBuilder product(List<Product> product) {
            this.product = product;
            return this;
        }

        public CartHTTPResponse build() {
            return new CartHTTPResponse(id, total, product);
        }
    }
}
