package com.onlineshoppingsystem.project.mapper;

import com.onlineshoppingsystem.project.data.User;
import com.onlineshoppingsystem.project.model.UserHTTPRequest;
import com.onlineshoppingsystem.project.model.UserHTTPResponse;

public class UserMapper {
    public static UserHTTPResponse map(User user){
        return UserHTTPResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
    public static User map(UserHTTPRequest userHTTPRequest){
        return User.userBuilder()
                .username(userHTTPRequest.getUsername())
                .password(userHTTPRequest.getPassword())
                .firstName(userHTTPRequest.getFirstName())
                .lastName(userHTTPRequest.getLastName())
                .build();
    }
}
