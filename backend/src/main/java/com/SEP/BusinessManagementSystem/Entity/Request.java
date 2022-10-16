package com.SEP.BusinessManagementSystem.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Request {
    @Id
    @SequenceGenerator(name="Request_Sequence", sequenceName = "Request_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Request_Sequence")
    private Long id;
    private int budget;
    private LocalDate dateOfCreation;
    private boolean isReviewedBySCS;
    private boolean isApprovedBySCS;
    private boolean isReviewedByFinancialManager;
    private boolean isApprovedByFinancialManager;
    private boolean isReviewedByAdminManager;
    private boolean isApprovedByAdminManager;
    private boolean isFinalized;

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

    public boolean isReviewedBySCS() {
        return isReviewedBySCS;
    }

    public void setReviewedBySCS(boolean reviewedBySCS) {
        isReviewedBySCS = reviewedBySCS;
    }

    public boolean isApprovedBySCS() {
        return isApprovedBySCS;
    }

    public void setApprovedBySCS(boolean approvedBySCS) {
        isApprovedBySCS = approvedBySCS;
    }

    public boolean isReviewedByFinancialManager() {
        return isReviewedByFinancialManager;
    }

    public void setReviewedByFinancialManager(boolean reviewedByFinancialManager) {
        isReviewedByFinancialManager = reviewedByFinancialManager;
    }

    public boolean isApprovedByFinancialManager() {
        return isApprovedByFinancialManager;
    }

    public void setApprovedByFinancialManager(boolean approvedByFinancialManager) {
        isApprovedByFinancialManager = approvedByFinancialManager;
    }

    public boolean isReviewedByAdminManager() {
        return isReviewedByAdminManager;
    }

    public void setReviewedByAdminManager(boolean reviewedByAdminManager) {
        isReviewedByAdminManager = reviewedByAdminManager;
    }

    public boolean isApprovedByAdminManager() {
        return isApprovedByAdminManager;
    }

    public void setApprovedByAdminManager(boolean approvedByAdminManager) {
        isApprovedByAdminManager = approvedByAdminManager;
    }

    public boolean isFinalized() {
        return isFinalized;
    }

    public void setFinalized(boolean finalized) {
        isFinalized = finalized;
    }
}
