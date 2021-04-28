package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserHTTPRequest {
    private String username;
    private String password;

    public UserHTTPRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static final class UserHTTPRequestBuilder {
        private String username;
        private String password;

        private UserHTTPRequestBuilder() {
        }

        public static UserHTTPRequestBuilder builder() {
            return new UserHTTPRequestBuilder();
        }

        public UserHTTPRequestBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserHTTPRequestBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserHTTPRequest build() {
            return new UserHTTPRequest(username, password);
        }
    }
}
