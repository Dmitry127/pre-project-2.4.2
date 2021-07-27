package ru.dmitrys.web.service;

import ru.dmitrys.web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User getUser(long id);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(long id);

}
