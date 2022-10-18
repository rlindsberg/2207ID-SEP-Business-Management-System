package com.SEP.BusinessManagementSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Subteam {
    @Id
    private Long id;
    private String name;
    private Long departmentID;
    private String title;

    public Subteam() {
    }

    public Subteam(Long id, String name, Long departmentID, String title) {
        this.id = id;
        this.name = name;
        this.departmentID = departmentID;
        this.title = title;
    }

    public Subteam(String name, Long departmentID, String title) {
        this.name = name;
        this.departmentID = departmentID;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
