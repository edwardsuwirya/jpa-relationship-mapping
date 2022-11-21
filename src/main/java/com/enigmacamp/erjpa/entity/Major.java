package com.enigmacamp.erjpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "M_MAJOR")
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private long majorId;
    @Column(name = "major_name", nullable = false, length = 100)
    private String majorName;

    @OneToMany(mappedBy = "major")
    private List<Student> studentList;

    public long getMajorId() {
        return majorId;
    }

    public void setMajorId(long majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId='" + majorId + '\'' +
                ", majorName='" + majorName + '\'' +
                '}';
    }
}
