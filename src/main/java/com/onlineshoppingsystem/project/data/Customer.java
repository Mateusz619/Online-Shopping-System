package com.onlineshoppingsystem.project.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
//@Data
//@Entity(name = "customer")
@NoArgsConstructor
public class Customer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
    private String firstName;
    private String lastName;
//    private String phoneNumber;
//    @OneToOne
//    @JoinColumn(name="user_id")
//    private UserInternal user;

//    public Customer(String firstName, String lastName, String phoneNumber, UserInternal user) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;dadasdasd
//        this.user = user;
//    }


    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}


