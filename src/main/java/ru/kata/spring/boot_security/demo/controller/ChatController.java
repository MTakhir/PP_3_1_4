package ru.kata.spring.boot_security.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;
import ru.kata.spring.boot_security.demo.model.Greeting;
import ru.kata.spring.boot_security.demo.model.HelloMessage;

@Controller
public class ChatController {

    @GetMapping("/chat")
    public String getChatPage() {
        return "chat";
    }
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) {
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}