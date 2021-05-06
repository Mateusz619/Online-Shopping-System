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

    public UserHTTPResponse(String username, String password, long id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }


    public static UserHTTPResponseBuilder builder() { return new UserHTTPResponseBuilder(); }
    public static final class UserHTTPResponseBuilder {
        private String username;
        private String password;
        private long id;

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

        public UserHTTPResponse build() {
            UserHTTPResponse userHTTPResponse = new UserHTTPResponse(username, password, id);
            userHTTPResponse.setUsername(username);
            userHTTPResponse.setPassword(password);
            userHTTPResponse.setId(id);
            return userHTTPResponse;
        }
    }
}
