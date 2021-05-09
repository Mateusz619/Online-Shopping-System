package model;

import com.onlineshoppingsystem.project.data.User;
import com.onlineshoppingsystem.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserHTTPResponse getUserById(long id) {
        User user = userRepository.findById(id).get();
        UserHTTPResponse response = UserMapper.map(user);
        return response;
    }

    public List<UserHTTPResponse> getAllUsers(User user) {
        return stream(userRepository.findAll().spliterator(), false)
                .map(x -> UserMapper.map(x))
                .collect(Collectors.toList());
    }

    public boolean delete(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void update(long id, UserHTTPRequest userHTTPRequest) {
        User user = UserMapper.map(userHTTPRequest);
        user.setId(id);
        userRepository.save(user);
    }

    public void create(UserHTTPRequest userHTTPRequest) {
        User user = UserMapper.map(userHTTPRequest);
        userRepository.save(user);
    }
}