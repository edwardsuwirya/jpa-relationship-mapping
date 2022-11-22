package com.enigmacamp.erjpa;

import com.enigmacamp.erjpa.constants.Gender;
import com.enigmacamp.erjpa.entity.*;
import com.enigmacamp.erjpa.repository.*;
import com.enigmacamp.erjpa.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Date;

public class App {
    public static void main(String[] args) throws InterruptedException {
        EntityManager entityManager = JpaUtil.getEntityManger();
        StudentRepository repository = new StudentRepositoryImpl(entityManager);
        MajorRepository majorRepository = new MajorRepositoryImpl(entityManager);
        GroupProjectRepository groupProjectRepository = new GroupProjectRepositoryImpl(entityManager);
        AuthenticationRepository authenticationRepository = new AuthenticationRepositoryImpl(entityManager);

        Major major = new Major();
        major.setMajorName("Accounting");
        majorRepository.create(major);


        GroupProject groupProject = new GroupProject();
        groupProject.setProjectName("React Framework Documentation");
        groupProjectRepository.create(groupProject);


        UserCredential userCredential = new UserCredential();
        userCredential.setUserName("joko");
        userCredential.setPassword("12345");
        authenticationRepository.create(userCredential);

        Student student = new Student();
        student.setGender(Gender.M);
        student.setFirstName("Joko");
        student.setLastName("Anwar");
        student.setBirthDate(new Date());
        student.setMajor(major);
        student.setUserCredential(userCredential);
        userCredential.setStudent(student);

        GroupProjectWithPoint groupProjectWithPoint = new GroupProjectWithPoint();
        groupProjectWithPoint.setPoint(0);
        groupProjectWithPoint.setStudent(student);
        groupProjectWithPoint.setGroupProject(groupProject);
        student.getProjectWithPoints().add(groupProjectWithPoint);
        groupProject.getProjectWithPoints().add(groupProjectWithPoint);

        repository.create(student);


//        GroupProject otherGroupProject = new GroupProject();
//        otherGroupProject.setProjectName("React Native Framework Documentation");
//        groupProjectRepository.create(otherGroupProject);
//
//        Student student = repository.findOne(1);
//        student.getGroupProjects().add(otherGroupProject);
//        otherGroupProject.getStudents().add(student);
//        repository.update(student);
//        System.out.println(student.getMajor().getMajorName());

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
