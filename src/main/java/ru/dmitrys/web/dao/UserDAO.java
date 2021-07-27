package ru.dmitrys.web.dao;

import ru.dmitrys.web.model.User;

import java.util.List;

public interface UserDAO {
    void saveUser(User user);

    User getUser(long id);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(long id);
}
