package com.onlineshoppingsystem.project.service;

import com.onlineshoppingsystem.project.data.User;
import com.onlineshoppingsystem.project.mapper.UserMapper;
import com.onlineshoppingsystem.project.model.UserHTTPRequest;
import com.onlineshoppingsystem.project.model.UserHTTPResponse;
import com.onlineshoppingsystem.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserHTTPResponse getUserById(long id) {
        return userRepository.findById(id)
                .map(UserMapper::map)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<UserHTTPResponse> getAllUsers() {
        return stream(userRepository.findAll().spliterator(), false)
                .map(UserMapper::map)
                .collect(Collectors.toList());
    }

    public long saveUser(UserHTTPRequest userHTTPRequest) {
        User user = UserMapper.map(userHTTPRequest);
        return userRepository.save(user).getId();
    }

    public long updateUserById(long id, UserHTTPRequest userHTTPRequest) {
        User user = UserMapper.map(userHTTPRequest);
        user.setId(id);
        return userRepository.save(user).getId();

    }

    public boolean deleteUserById(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}