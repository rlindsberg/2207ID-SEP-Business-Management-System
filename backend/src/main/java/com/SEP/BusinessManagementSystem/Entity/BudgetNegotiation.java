package com.SEP.BusinessManagementSystem.Entity;

import javax.persistence.*;

@Entity
@Table
public class BudgetNegotiation {
    @Id
    @SequenceGenerator(name="Negotiation_Sequence", sequenceName = "Negotiation_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Negotiation_Sequence")
    private Long id;
    private int expectedBudget;
    private boolean isApprovedByFinancialManager;
    private boolean isRejectedByFinancialManager;

    public BudgetNegotiation() {
    }

    public BudgetNegotiation(Long id, int expectedBudget, boolean isApprovedByFinancialManager) {
        this.id = id;
        this.expectedBudget = expectedBudget;
        this.isApprovedByFinancialManager = isApprovedByFinancialManager;
    }

    public BudgetNegotiation(int expectedBudget, boolean isApprovedByFinancialManager) {
        this.expectedBudget = expectedBudget;
        this.isApprovedByFinancialManager = isApprovedByFinancialManager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getExpectedBudget() {
        return expectedBudget;
    }

    public void setExpectedBudget(int expectedBudget) {
        this.expectedBudget = expectedBudget;
    }

    public boolean isApprovedByFinancialManager() {
        return isApprovedByFinancialManager;
    }

    public void setApprovedByFinancialManager(boolean approvedByFinancialManager) {
        isApprovedByFinancialManager = approvedByFinancialManager;
    }

    public boolean isRejectedByFinancialManager() {
        return isRejectedByFinancialManager;
    }

    public void setRejectedByFinancialManager(boolean rejectedByFinancialManager) {
        isRejectedByFinancialManager = rejectedByFinancialManager;
    }
}
