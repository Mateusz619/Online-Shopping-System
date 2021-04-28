package com.onlineshoppingsystem.project.controller;

import com.onlineshoppingsystem.project.data.User;
import model.UserDTO;
import com.onlineshoppingsystem.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    private Long id;


    @GetMapping(value = "users")
    public ResponseEntity getAllUser(){return ResponseEntity.ok(userRepository.findAll());}

    @GetMapping(value = "user/{id}")
    public User getUserById(@PathVariable long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User doesn't exist"));
    }

    @DeleteMapping(value = "delete/{user}")
    public void deleteByUserId(Long id){
        userRepository.deleteById(id);
    }
    @PutMapping(value = "update/{user}")
    public User updateByUserId(@RequestBody User newUser, @PathVariable long id){
        return userRepository.findById(id)
                .map(element -> {
                    element.setId(newUser.getId());
                    element.setUsername(newUser.getUsername());
                    element.setPassword(newUser.getPassword());
                    return userRepository.save(element);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return  userRepository.save(newUser);
                });
    }
    @PostMapping(value = "user")
    public ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO){
        User user = new User(userDTO.getUsername(),userDTO.getPassword());
        return ResponseEntity.ok(userRepository.save(user));
    }
}
