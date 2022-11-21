package com.enigmacamp.erjpa.repository;

import com.enigmacamp.erjpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private final EntityManager entityManager;

    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Student student) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    @Override
    public Student findOne(long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll(int page, int pageSize) {
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery("SELECT s FROM Student s order by s.studentId", Student.class);
        studentTypedQuery.setFirstResult((page - 1) * pageSize);
        studentTypedQuery.setMaxResults(pageSize);
        return studentTypedQuery.getResultList();
    }

    @Override
    public void update(Student student) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
}
