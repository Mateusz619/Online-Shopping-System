package com.onlineshoppingsystem.project.project.service;

import com.onlineshoppingsystem.project.data.UserInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInternal userInternal = userService.getUserByName(username);
        if (userInternal == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(userInternal.getUsername(), userInternal.getPassword(), getAuthorities(userInternal));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(UserInternal userInternal) {
        return Collections.singletonList(new SimpleGrantedAuthority(userInternal.getRole().name()));
    }
}
