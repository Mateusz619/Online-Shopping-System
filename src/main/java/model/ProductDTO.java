package model;

import lombok.Data;

@Data
public class ProductDTO {

    private String type;
    private String name;
    private float price;
    private int quantity;
}
