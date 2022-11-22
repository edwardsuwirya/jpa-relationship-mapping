package com.enigmacamp.erjpa.entity;

import com.enigmacamp.erjpa.constants.Gender;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.*;

@Entity
@Table(name = "M_STUDENT")
@DynamicUpdate
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(columnDefinition = "varchar(1)")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id")
    private Major major;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "credential_id")
    private UserCredential userCredential;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @ManyToMany
    @JoinTable(
            name = "M_STUDENT_PROJECT",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<GroupProject> groupProjects = new HashSet<>();

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public UserCredential getUserCredential() {
        return userCredential;
    }

    public void setUserCredential(UserCredential userCredential) {
        this.userCredential = userCredential;
    }

    public Set<GroupProject> getGroupProjects() {
        return groupProjects;
    }

    public void setGroupProjects(Set<GroupProject> groupProjects) {
        this.groupProjects = groupProjects;
    }

    public void addGroupProject(GroupProject project) {
        this.getGroupProjects().add(project);
        project.getStudents().add(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", major='" + major + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
