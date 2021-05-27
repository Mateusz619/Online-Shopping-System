package com.onlineshoppingsystem.project.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserHTTPRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public UserHTTPRequest(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static UserHTTPRequestBuilder builder() {
        return new UserHTTPRequestBuilder();
    }

    public static final class UserHTTPRequestBuilder {
        private String username;
        private String password;
        private String firstName;
        private String lastName;

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

        public UserHTTPRequest build() {
            return new UserHTTPRequest(username, password, firstName, lastName);
        }
    }
}
