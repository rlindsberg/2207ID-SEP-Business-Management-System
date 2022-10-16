package com.SEP.BusinessManagementSystem.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Task {
    @Id
    private Long id;
    private String name;
    private LocalDate dueDate;
    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private Subteam assignee;
    public Task(Long id, String name, LocalDate dueDate, Subteam assignee) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.assignee = assignee;
    }

    public Task() {
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Subteam getAssignee() {
        return assignee;
    }

    public void setAssignee(Subteam assignee) {
        this.assignee = assignee;
    }
}
