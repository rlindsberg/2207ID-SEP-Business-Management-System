package com.SEP.BusinessManagementSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Request {
    @Id
    private Long id;
    private int budget;
    private LocalDate dateOfCreation;

    public Request() {}
    public Request(Long id, int budget, LocalDate dateOfCreation) {
        this.id = id;
        this.budget = budget;
        this.dateOfCreation = dateOfCreation;
    }

    public Request(int budget, LocalDate dateOfCreation) {
        this.budget = budget;
        this.dateOfCreation = dateOfCreation;
    }

    public Long getId() {
        return id;
    }


    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
