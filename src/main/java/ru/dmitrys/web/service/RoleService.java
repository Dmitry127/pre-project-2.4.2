package ru.dmitrys.web.service;

import ru.dmitrys.web.model.Role;

import java.util.Set;

public interface RoleService {

    Role getRole(String role);

    Set<Role> getRoleSet(String role);
}
