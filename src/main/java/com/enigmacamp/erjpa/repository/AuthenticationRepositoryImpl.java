package com.enigmacamp.erjpa.repository;

import com.enigmacamp.erjpa.entity.UserCredential;
import jakarta.persistence.EntityManager;

public class AuthenticationRepositoryImpl implements AuthenticationRepository {
    private final EntityManager entityManager;

    public AuthenticationRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void create(UserCredential userCredential) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userCredential);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserCredential findOne(String id) {
        return entityManager.find(UserCredential.class, id);
    }
}
