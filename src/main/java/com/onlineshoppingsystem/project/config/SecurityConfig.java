package com.onlineshoppingsystem.project.config;

import com.onlineshoppingsystem.project.config.filter.JWTAuthenticationFilter;
import com.onlineshoppingsystem.project.config.filter.JWTAuthorizationFilter;
import com.onlineshoppingsystem.project.service.AuthenticationUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationUserDetailService authenticationUserDetailService;

    @Autowired
    public SecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationUserDetailService authenticationUserDetailService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationUserDetailService = authenticationUserDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/console/**").permitAll()
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                .antMatchers(HttpMethod.POST, "/signup").permitAll()
                .antMatchers("/user/**").hasRole("ADMINISTRATOR")
                .antMatchers("/cart/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/product/get").permitAll()
                .antMatchers(HttpMethod.GET,"/product/get/{id}").hasAnyRole("ADMINISTRATOR","CUSTOMER")
                .antMatchers("/product/**").hasRole("ADMINISTRATOR")
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }
}
