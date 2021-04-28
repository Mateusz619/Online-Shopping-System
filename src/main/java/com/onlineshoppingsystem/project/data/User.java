package com.onlineshoppingsystem.project.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_User")
    private long id;
    private String username;
    private String password;

    User(){
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public static UserBuilder userBuilder(){return new UserBuilder();}
    public static final class UserBuilder {
        private long id;
        private String username;
        private String password;

        private UserBuilder() {
        }

        public UserBuilder id(long id) {
            this.id = id;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            return user;
        }
    }
}
