package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Chat;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    List<Chat> getUsersChat(int id);
    void save(User user);
    User findByEmail(String email);
    void update(User user);
    void delete(int id);
    boolean exist(String email);
}
