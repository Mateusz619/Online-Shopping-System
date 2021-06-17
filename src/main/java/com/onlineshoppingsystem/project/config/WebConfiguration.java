package com.onlineshoppingsystem.project.config;

import com.onlineshoppingsystem.project.data.Role;
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

    @Bean
    public void initializer() {
        userRepository.save(new UserInternal("jan.kowalski", bCryptPasswordEncoder().encode("user"), "Jan", "Kowalski", Role.ROLE_CUSTOMER));
        userRepository.save(new UserInternal("adam.nowak", bCryptPasswordEncoder().encode("admin"), "Adam", "Nowak", Role.ROLE_ADMINISTRATOR));
    }
}
