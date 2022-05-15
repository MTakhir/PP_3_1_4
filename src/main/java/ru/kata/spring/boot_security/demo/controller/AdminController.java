package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers() {
        return "admin";
    }

    @PostMapping()
    public String addUser (@ModelAttribute("user") User user,
                           @RequestParam(value = "rolesList") String [] roles,
                           @ModelAttribute("pass") String pass) {

        userService.save(user, roles, pass);
        return "redirect:/admin";
    }




}
