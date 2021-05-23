package com.onlineshoppingsystem.project.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserHTTPResponse {
    private long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public UserHTTPResponse(String username, String password, long id, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
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

        private UserHTTPResponseBuilder() {
        }

        public UserHTTPResponseBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserHTTPResponseBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserHTTPResponseBuilder id(long id) {
            this.id = id;
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

        public UserHTTPResponse build() {
            UserHTTPResponse userHTTPResponse = new UserHTTPResponse(username, password, id, firstName, lastName);
            userHTTPResponse.setUsername(username);
            userHTTPResponse.setPassword(password);
            userHTTPResponse.setId(id);
            userHTTPResponse.setFirstName(firstName);
            userHTTPResponse.setLastName(lastName);
            return userHTTPResponse;
        }
    }
}
