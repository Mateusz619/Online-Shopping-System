package com.onlineshoppingsystem.project.controller;

import com.onlineshoppingsystem.project.model.UserHTTPRequest;
import com.onlineshoppingsystem.project.model.UserHTTPResponse;
import com.onlineshoppingsystem.project.model.UserService;
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


    @GetMapping(value = "users")
    public List<UserHTTPResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "user/{id}")
    public UserHTTPResponse getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteByUserId(@PathVariable long id){
        userService.delete(id);
    }
    @PutMapping(value = "update/{id}")
    public void updateByUserId(@PathVariable long id, @RequestBody UserHTTPRequest userHTTPRequest){
        userService.update(id, userHTTPRequest);
    }
    @PostMapping(value = "user")
    public void saveUser(@RequestBody UserHTTPRequest userHTTPRequest){
        userService.create(userHTTPRequest);
    }
}
