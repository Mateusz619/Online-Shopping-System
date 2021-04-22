package com.onlineshoppingsystem.project.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "Admin")
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Admin")
    private int id;
    private String username;
    private String password;
    private boolean access;

    public Admin(int id, String username, String password, boolean access) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.access = access;
    }
}
