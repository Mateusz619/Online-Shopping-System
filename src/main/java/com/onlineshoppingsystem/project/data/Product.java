package com.onlineshoppingsystem.project.data;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Product")
    private int id;
    private float price;
    private int quantity;
    private String type;
    private String name;
    private String group;
    private String subgroup;

    public Product(float price,int quantity,String type,String name,String group,String subgroup, int id){
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.name = name;
        this.group = group;
        this.subgroup = subgroup;
        this.id = id;
    }
}
