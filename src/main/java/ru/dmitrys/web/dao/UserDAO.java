package ru.dmitrys.web.dao;

import ru.dmitrys.web.model.Role;
import ru.dmitrys.web.model.User;

import java.util.List;

public interface UserDAO {
    void saveUser(User user);

    User getUser(long id);

    User getUser(String login);

    Role getRole(String role);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(long id);

    void deleteUser(String login);
}
