package com.onlineshoppingsystem.project.dto;

import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String username;
    private String password;

    public UserDTO(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}