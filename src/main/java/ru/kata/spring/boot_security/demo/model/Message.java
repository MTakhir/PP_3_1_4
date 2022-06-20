package ru.kata.spring.boot_security.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fromUserName;
    private String toUserName;
    private String content;
    @ManyToOne
    private Chat chat;

    public Message() {
    }
}