package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbInit {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void postConstruct() {
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        if(!roleService.exist(adminRole.getAuthority())) {
            roleService.save(adminRole);
        }

        if(!roleService.exist(userRole.getAuthority())) {
            roleService.save(userRole);
        }

        if (!userService.exist("admin")) {
            List<Role> adminRolesList = new ArrayList<>();
            adminRolesList.add(adminRole);
            adminRolesList.add(userRole);
            User admin = new User("admin", "admin", 42, "admin",
                    "admin",adminRolesList);
            userService.save(admin);
        }

        if (!userService.exist("user")) {
            List<Role> userRolesList = new ArrayList<>();
            userRolesList.add(userRole);
            User user = new User("user", "user", 42, "user",
                    "user", userRolesList);
            userService.save(user);
        }
    }
}
