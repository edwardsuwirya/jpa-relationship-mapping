package com.enigmacamp.erjpa;

import com.enigmacamp.erjpa.constants.Gender;
import com.enigmacamp.erjpa.entity.Student;
import com.enigmacamp.erjpa.repository.StudentRepository;
import com.enigmacamp.erjpa.repository.StudentRepositoryImpl;
import com.enigmacamp.erjpa.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManger();
        StudentRepository repository = new StudentRepositoryImpl(entityManager);

//        Student student = new Student();
//        student.setGender(Gender.M);
//        student.setFirstName("Joko");
//        student.setLastName("Anwar");
//        student.setBirthDate(new Date());
//        student.setMajor("Accounting");
//        repository.create(student);

        Student student = new Student();
        student.setStudentId(1);
        student.setGender(Gender.M);
        student.setFirstName("Joko");
        student.setBirthDate(new Date());
        student.setLastName("Anwar");
        student.setMajor("Informatics");
        repository.update(student);

    }
}
