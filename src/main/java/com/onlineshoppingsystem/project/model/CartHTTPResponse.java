package com.onlineshoppingsystem.project.model;


import com.onlineshoppingsystem.project.data.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartHTTPResponse {
    private Product product;
    private long id;

    public CartHTTPResponse( Product product, long id) {

        this.product.equals(product);
        this.id = id;
    }

    public static CartHTTPResponseBuilder builder() {
        return new CartHTTPResponseBuilder();
    }

    public static final class CartHTTPResponseBuilder {
        private Product product;
        private long id;

        private CartHTTPResponseBuilder() {
        }

        public CartHTTPResponseBuilder product(Product product) {
            this.product = product;
            return this;
        }

        public CartHTTPResponseBuilder id(long id) {
            this.id = id;
            return this;
        }

        public CartHTTPResponse build() {
            return new CartHTTPResponse(product, id);
        }
    }
 }
