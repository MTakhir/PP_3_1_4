package ru.kata.spring.boot_security.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "chatList")
    private List<User> subscribers;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    private List<Message> messageList;

}
