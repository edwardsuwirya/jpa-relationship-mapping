package com.enigmacamp.erjpa;

import com.enigmacamp.erjpa.constants.Gender;
import com.enigmacamp.erjpa.entity.Major;
import com.enigmacamp.erjpa.entity.Student;
import com.enigmacamp.erjpa.entity.UserCredential;
import com.enigmacamp.erjpa.repository.*;
import com.enigmacamp.erjpa.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Date;

public class App {
    public static void main(String[] args) throws InterruptedException {
        EntityManager entityManager = JpaUtil.getEntityManger();
        StudentRepository repository = new StudentRepositoryImpl(entityManager);
        MajorRepository majorRepository = new MajorRepositoryImpl(entityManager);
        Major major = new Major();
//        major.setMajorId(1);
        major.setMajorName("Accounting");
        majorRepository.create(major);
        entityManager.detach(major);
        boolean isExist = entityManager.contains(major);
        System.out.println(isExist);
        System.out.println(major);

//        AuthenticationRepository authenticationRepository = new AuthenticationRepositoryImpl(entityManager);
        UserCredential userCredential = new UserCredential();
        userCredential.setUserName("linda");
        userCredential.setPassword("12345");
//        authenticationRepository.create(userCredential);

        Student student = new Student();
        student.setGender(Gender.M);
        student.setFirstName("Linda");
        student.setLastName("Kurniawan");
        student.setBirthDate(new Date());
        student.setMajor(major);
        student.setUserCredential(userCredential);
        userCredential.setStudent(student);
        repository.create(student);

        Student s = repository.findOne(1);
        System.out.println(s.getMajor().getMajorName());

//        Major major1 = majorRepository.findOne(1);
//        for (Student student1 : major1.getStudentList()) {
//            System.out.println(student1.getUserCredential());
//        }

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
