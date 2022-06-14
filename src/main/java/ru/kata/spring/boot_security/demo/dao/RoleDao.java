package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

public interface RoleDao {
    Role findByRole (String role);
    void save (Role role);
    boolean exist(String role);

}
