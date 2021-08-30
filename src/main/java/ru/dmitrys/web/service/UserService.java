package ru.dmitrys.web.service;

import ru.dmitrys.web.model.Role;
import ru.dmitrys.web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void saveUser(User user);

    User getUser(long id);

    User getUser(String login);

    Role getRole(String role);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(long id);

    Set<Role> getRoleSet(String role);

    void deleteUser(String login);

}
