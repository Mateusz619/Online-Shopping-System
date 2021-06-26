package com.onlineshoppingsystem.project.project.controller;

import com.onlineshoppingsystem.project.model.UserHTTPRequest;
import com.onlineshoppingsystem.project.model.UserHTTPResponse;
import com.onlineshoppingsystem.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/get/{id}")
    public UserHTTPResponse getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @GetMapping(value = "/user/get")
    public List<UserHTTPResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/signup")
    public long saveUser(@RequestBody UserHTTPRequest userHTTPRequest){
        return userService.saveUser(userHTTPRequest);
    }

    @PutMapping(value = "/user/update/{id}")
    public long updateUserById(@PathVariable long id, @RequestBody UserHTTPRequest userHTTPRequest){
        return userService.updateUserById(id, userHTTPRequest);
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public boolean deleteUserById(@PathVariable long id){
        return userService.deleteUserById(id);
    }
}