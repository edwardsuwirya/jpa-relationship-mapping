package com.enigmacamp.erjpa;

import com.enigmacamp.erjpa.constants.Gender;
import com.enigmacamp.erjpa.entity.Student;
import com.enigmacamp.erjpa.entity.UserCredential;
import com.enigmacamp.erjpa.repository.AuthenticationRepository;
import com.enigmacamp.erjpa.repository.AuthenticationRepositoryImpl;
import com.enigmacamp.erjpa.repository.StudentRepository;
import com.enigmacamp.erjpa.repository.StudentRepositoryImpl;
import com.enigmacamp.erjpa.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Date;

public class App {
    public static void main(String[] args) throws InterruptedException {
        EntityManager entityManager = JpaUtil.getEntityManger();
        StudentRepository repository = new StudentRepositoryImpl(entityManager);

//        AuthenticationRepository authenticationRepository = new AuthenticationRepositoryImpl(entityManager);
//        UserCredential userCredential = new UserCredential();
//        userCredential.setUserName("joko");
//        userCredential.setPassword("12345");
//        authenticationRepository.create(userCredential);

//        Student student = new Student();
//        student.setGender(Gender.M);
//        student.setFirstName("Joko");
//        student.setLastName("Anwar");
//        student.setBirthDate(new Date());
//        student.setMajor("Informatics");
//        student.setUserCredential(userCredential);
//        repository.create(student);

        Student student = repository.findOne(2);
        entityManager.detach(student);
        System.out.println(student.getUserCredential());


//        AuthenticationRepository authenticationRepository = new AuthenticationRepositoryImpl(entityManager);
//        userCredential.setStudent(student);
//        student.setUserCredential(userCredential);
//        authenticationRepository.create(userCredential);

//        UserCredential credential = authenticationRepository.findOne("joko");
//        System.out.println(credential.getUserName());
//        Thread.sleep(1000);
//        System.out.println(credential.getStudent().getFirstName());

//        Student student = new Student();
//        student.setStudentId(1);
//        student.setGender(Gender.M);
//        student.setFirstName("Joko");
//        student.setBirthDate(new Date());
//        student.setLastName("Anwar");
//        student.setMajor("Informatics");
//        repository.update(student);

    }
}
