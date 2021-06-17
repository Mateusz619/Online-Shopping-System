package com.onlineshoppingsystem.project.mapper;

import com.onlineshoppingsystem.project.data.UserInternal;
import com.onlineshoppingsystem.project.model.UserHTTPRequest;
import com.onlineshoppingsystem.project.model.UserHTTPResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper {

    public static UserHTTPResponse map(UserInternal user){
        return UserHTTPResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .build();
    }
    public static UserInternal map(UserHTTPRequest userHTTPRequest){
        return UserInternal.userBuilder()
                .username(userHTTPRequest.getUsername())
                .password(userHTTPRequest.getPassword())
                .firstName(userHTTPRequest.getFirstName())
                .lastName(userHTTPRequest.getLastName())
                .role(userHTTPRequest.getRole())
                .build();
    }
}
