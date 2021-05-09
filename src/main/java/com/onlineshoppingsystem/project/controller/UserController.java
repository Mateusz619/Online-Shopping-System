package com.onlineshoppingsystem.project.controller;

import com.onlineshoppingsystem.project.data.User;
import model.UserHTTPRequest;
import model.UserHTTPResponse;
import model.UserService;
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
    public List<UserHTTPResponse> getAllUsers(@PathVariable User id) {
        return userService.getAllUsers(id);
    }

    @GetMapping(value = "user/{id}")
    public UserHTTPResponse getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @DeleteMapping(value = "delete/{user}")
    public void deleteByUserId(Long id){
        userService.delete(id);
    }
    @PutMapping(value = "update/{user}")
    public void updateByUserId(@PathVariable long id, @RequestBody UserHTTPRequest userHTTPRequest){
        userService.update(id, userHTTPRequest);
    }
    @PostMapping(value = "user")
    public void saveUser(@RequestBody UserHTTPRequest userHTTPRequest){
        userService.create(userHTTPRequest);
    }
}
