package com.enigmacamp.erjpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sys_user_credential")
public class UserCredential {
    @Id
    @Column(name = "user_name")
    private String userName;

    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "userCredential")
    Student student;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "UserCredential{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
