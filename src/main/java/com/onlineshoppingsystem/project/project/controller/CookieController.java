package com.onlineshoppingsystem.project.project.controller;

import com.onlineshoppingsystem.project.project.data.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
public class CookieController {

    @GetMapping("/")
    public Cart readCookie(@CookieValue(value = "cart", defaultValue = "empty") Cart cart) {
        return cart;
    }

    @GetMapping("/Cookie")
    public String setCookie(HttpServletResponse response) {


        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("cart", "addItem");
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/Cart");
        response.addCookie(cookie);

        return "Create Cookie";
    }

    @GetMapping("/allCookies")
    public String readAllCookies(HttpServletRequest request) {

        javax.servlet.http.Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies)
                    .map(c -> c.getName() + c.getValue()).collect(Collectors.joining(", "));
        }

        return "No cookies";
    }
}
