package com.onlineshoppingsystem.project.project.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private long id;
    private String type;
    private String name;
    private float price;

    public Product(String type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static final class ProductBuilder {
        private long id;
        private String type;
        private String name;
        private float price;

        private ProductBuilder() {
        }

        public ProductBuilder id(long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder type(String type) {
            this.type = type;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder price(float price) {
            this.price = price;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setId(id);
            product.setType(type);
            product.setName(name);
            product.setPrice(price);
            return product;
        }
    }
}
