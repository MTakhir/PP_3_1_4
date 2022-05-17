package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class RestAdminController {

    private UserService userService;

    @Autowired
    public RestAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> allUsersRest() {
        return userService.getUsers();
    }

    @GetMapping("/user")
    public User navBar(Principal principal) {
        return userService.findByEmail(principal.getName());
    }

    @PostMapping()
    public ResponseEntity<User> addUser (@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @PutMapping()
    public void update (@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) {
        userService.delete(id);
    }
}
