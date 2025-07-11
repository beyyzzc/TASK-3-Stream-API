package service;

import model.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    @Override
    public List<String> getNamesOfAdults(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() >= 18)
                .map(User::getName)
                .collect(Collectors.toList());
    }
}

