package com.onlineshoppingsystem.project.data;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "Payment")
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Payment")
    private Integer id;
    private String paymentOptions;
    private String cardType;

    public Payment(Integer id, String paymentOptions, String cardType) {
        this.id = id;
        this.paymentOptions = paymentOptions;
        this.cardType = cardType;
    }
}
