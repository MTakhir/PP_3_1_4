package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Chat;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ChatDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Chat chat) {
        entityManager.persist(chat);
    }

    public void delete(int id) {
        Chat chat = entityManager.find(Chat.class, id);
        entityManager.remove(chat);
    }
}
