package com.enigmacamp.erjpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "M_GROUP_PROJECT")
public class GroupProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long projectId;

    @Column(name = "project_name", nullable = false, length = 50)
    private String projectName;

    @OneToMany(mappedBy = "groupProject")
    private List<GroupProjectWithPoint> projectWithPoints =new ArrayList<>();

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<GroupProjectWithPoint> getProjectWithPoints() {
        return projectWithPoints;
    }

    public void setProjectWithPoints(List<GroupProjectWithPoint> projectWithPoints) {
        this.projectWithPoints = projectWithPoints;
    }
}
