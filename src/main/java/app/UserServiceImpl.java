package app;

import app.exceptions.NotFoundException;
import app.interfaces.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    // TODO: 4/21/21 mb map
    private final List<User> users = new ArrayList<>();

    public UserServiceImpl(){

    }

    @Override
    public User saveUser(String name) {
        User user = new User(name, String.valueOf(users.size() + 1));
        users.add(user);
        return user;
    }

    @Override
    public User getUserById(String id) {
        return users.stream()
                .filter(user->user.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new NotFoundException("user not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}