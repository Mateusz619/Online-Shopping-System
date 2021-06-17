package com.onlineshoppingsystem.project.model;
import com.onlineshoppingsystem.project.data.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class UserHTTPResponse {
    private long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Role role;

    public UserHTTPResponse(long id, String username, String password, String firstName, String lastName, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public static UserHTTPResponseBuilder builder() {
        return new UserHTTPResponseBuilder();
    }

    public static final class UserHTTPResponseBuilder {
        private long id;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private Role role;

        private UserHTTPResponseBuilder() {
        }

        public UserHTTPResponseBuilder id(long id) {
            this.id = id;
            return this;
        }

        public UserHTTPResponseBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserHTTPResponseBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserHTTPResponseBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserHTTPResponseBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserHTTPResponseBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public UserHTTPResponse build() {
            return new UserHTTPResponse(id, username, password, firstName, lastName, role);
        }
    }
}
