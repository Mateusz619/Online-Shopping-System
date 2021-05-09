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
    private String firstName;
    private String surname;

    public UserHTTPResponse(String username, String password, long id, String firstName, String surname) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.firstName = this.firstName;
        this.surname = this.surname;
    }


    public static UserHTTPResponseBuilder builder() { return new UserHTTPResponseBuilder(); }
    public static final class UserHTTPResponseBuilder {
        private String username;
        private String password;
        private long id;
        private String firstName;
        private String surname;

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
        public UserHTTPResponseBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserHTTPResponse build() {
            UserHTTPResponse userHTTPResponse = new UserHTTPResponse(username, password, id, firstName, surname);
            userHTTPResponse.setUsername(username);
            userHTTPResponse.setPassword(password);
            userHTTPResponse.setId(id);
            userHTTPResponse.setFirstName(firstName);
            userHTTPResponse.setSurname(surname);
            return userHTTPResponse;
        }
    }
}
