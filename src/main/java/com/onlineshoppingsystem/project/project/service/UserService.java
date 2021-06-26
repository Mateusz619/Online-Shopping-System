package com.onlineshoppingsystem.project.project.service;

import com.onlineshoppingsystem.project.data.UserInternal;
import com.onlineshoppingsystem.project.mapper.UserMapper;
import com.onlineshoppingsystem.project.model.UserHTTPRequest;
import com.onlineshoppingsystem.project.model.UserHTTPResponse;
import com.onlineshoppingsystem.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserInternal getUserByName(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(EntityNotFoundException::new);
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
        Optional<UserInternal> checkUser = userRepository.findByUsername(userHTTPRequest.getUsername());
        if (checkUser.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }

        UserInternal user = UserMapper.map(userHTTPRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user).getId();
    }

    public long updateUserById(long id, UserHTTPRequest userHTTPRequest) {
        UserInternal user = UserMapper.map(userHTTPRequest);
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