package model;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.User;

@Getter
@Setter
public class UserHTTPResponse {
    private String username;
    private String password;
    private long id;

    public static UserHTTPResponseBuilder userHTTPResponseBuilder() { return new UserHTTPResponseBuilder(); }
    public static final class UserHTTPResponseBuilder {
        private String username;
        private String password;
        private long id;

        private UserHTTPResponseBuilder() {
        }


        public UserHTTPResponseBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserHTTPResponseBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserHTTPResponseBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public UserHTTPResponse build() {
            UserHTTPResponse userHTTPResponse = new UserHTTPResponse();
            userHTTPResponse.setUsername(username);
            userHTTPResponse.setPassword(password);
            userHTTPResponse.setId(id);
            return userHTTPResponse;
        }
    }
}
