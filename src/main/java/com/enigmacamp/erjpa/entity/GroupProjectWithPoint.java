package com.enigmacamp.erjpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "M_GROUP_PROJECT_POINT")
public class GroupProjectWithPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_point_id")
    long projectPointId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @JoinColumn(name = "project_id")
    GroupProject groupProject;

    int point;

    public long getProjectPointId() {
        return projectPointId;
    }

    public void setProjectPointId(long projectPointId) {
        this.projectPointId = projectPointId;
    }



    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public GroupProject getGroupProject() {
        return groupProject;
    }

    public void setGroupProject(GroupProject groupProject) {
        this.groupProject = groupProject;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}

