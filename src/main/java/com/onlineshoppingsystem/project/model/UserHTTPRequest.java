package com.onlineshoppingsystem.project.model;

import com.onlineshoppingsystem.project.data.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class UserHTTPRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Role role;

    public UserHTTPRequest(String username, String password, String firstName, String lastName, Role role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public static UserHTTPRequestBuilder builder() {
        return new UserHTTPRequestBuilder();
    }

    public static final class UserHTTPRequestBuilder {
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private Role role;

        private UserHTTPRequestBuilder() {
        }

        public UserHTTPRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserHTTPRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserHTTPRequestBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserHTTPRequestBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserHTTPRequestBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public UserHTTPRequest build() {
            return new UserHTTPRequest(username, password, firstName, lastName, role);
        }
    }
}
