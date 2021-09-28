package ru.dmitrys.web.dao;

import ru.dmitrys.web.model.Role;

public interface RoleDAO {

    void saveRole(Role role);

    Role getRole(String role);

    void deleteRole(String role);
}
