package service;

import model.User;
import java.util.List;

public interface UserService {
    List<String> getNamesOfAdults(List<User> users);
}

