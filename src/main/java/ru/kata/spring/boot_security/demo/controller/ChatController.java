package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;
import ru.kata.spring.boot_security.demo.model.Message;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
public class ChatController {

    private UserService userService;

    @Autowired
    public ChatController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/chat")
    public String getChatPage() {
        return "chat";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Principal principal) {
        User user = userService.findByEmail(principal.getName());
        return new Message("Hello, " + user.getFirstName() +" " + user.getLastName() + "!");
    }

}