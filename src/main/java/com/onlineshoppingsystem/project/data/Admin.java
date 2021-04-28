package com.onlineshoppingsystem.project.data;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter
@Setter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String addProducts;
    private String deleteProducts;
    private String modifyProducts;
    private String makeShipment;
    private String confirmDelivery;

    public Admin(int id, String username, String password, String addProducts,
                 String deleteProducts, String modifyProducts, String makeShipment, String confirmDelivery) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.addProducts = addProducts;
        this.deleteProducts = deleteProducts;
        this.modifyProducts = modifyProducts;
        this.makeShipment = makeShipment;
        this.confirmDelivery = confirmDelivery;
    }


}

