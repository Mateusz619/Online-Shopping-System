package com.onlineshoppingsystem.project.config;

import com.onlineshoppingsystem.project.data.UserInternal;
import com.onlineshoppingsystem.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class WebConfiguration {

    private final UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public void init() {
//        userRepository.save(new UserInternal())
//    }
}
