package com.enigmacamp.erjpa.repository;

import com.enigmacamp.erjpa.entity.GroupProject;
import jakarta.persistence.EntityManager;

public class GroupProjectRepositoryImpl implements GroupProjectRepository {
    private final EntityManager entityManager;

    public GroupProjectRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(GroupProject project) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(project);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public GroupProject findOne(long id) {
        return entityManager.find(GroupProject.class, id);
    }
}
