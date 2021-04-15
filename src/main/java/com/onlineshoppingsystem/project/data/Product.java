package com.onlineshoppingsystem.project.data;

import javax.persistence.Entity;

@Entity
public class Product {
    private float price;
    private int quantity;
    private String type;
    private String name;
    private String group;
    private String subgroup;
    private int id;

    Product(){

    }
    public Product(float price,int quantity,String type,String name,String group,String subgroup, int id){
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.name = name;
        this.group = group;
        this.subgroup = subgroup;
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
