package model;

import com.onlineshoppingsystem.project.data.User;

public class UserMapper {
    public static UserHTTPResponse map(User user){
        return UserHTTPResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
    public static User map(UserHTTPRequest user){
        return User.userBuilder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
