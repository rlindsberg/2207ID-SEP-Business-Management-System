package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.BudgetNegotiation;
import com.SEP.BusinessManagementSystem.Repository.BudgetNegotiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BudgetNegotiationService {
    private final BudgetNegotiationRepository budgetNegotiationRepository;


    @Autowired
    public BudgetNegotiationService(BudgetNegotiationRepository budgetNegotiationRepository) {
        this.budgetNegotiationRepository = budgetNegotiationRepository;
    }

    public BudgetNegotiation getBudgetNegotiationById(Long id){
        Optional<BudgetNegotiation> budgetNegotiationOptional = budgetNegotiationRepository.findById(id);
        if (budgetNegotiationOptional.isEmpty()) {
            throw new RuntimeException("Budget Negotiation not found!");
        }
        return budgetNegotiationOptional.get();
    }

    public BudgetNegotiation createNewBudgetNegotiation(BudgetNegotiation budgetNegotiation) {

        return budgetNegotiationRepository.save(budgetNegotiation);
    }

    public BudgetNegotiation updateExpectedBudget(Long id, int expectedBudget) {
        Optional<BudgetNegotiation> budgetNegotiationOptional = budgetNegotiationRepository.findById(id);
        if (budgetNegotiationOptional.isEmpty()) {
            throw new RuntimeException("Budget Negotiation not found!");
        }
        BudgetNegotiation budgetNegotiation = budgetNegotiationOptional.get();
        budgetNegotiation.setExpectedBudget(expectedBudget);
        return budgetNegotiationRepository.save(budgetNegotiation);
    }


    public BudgetNegotiation approveBudgetNegotiationByFMById(Long id) {
        Optional<BudgetNegotiation> budgetNegotiationOptional = budgetNegotiationRepository.findById(id);
        if (budgetNegotiationOptional.isEmpty()) {
            throw new RuntimeException("budget negotiation not found!");
        }
        BudgetNegotiation budgetNegotiation = budgetNegotiationOptional.get();
        //set approved to true
        budgetNegotiation.setApprovedByFinancialManager(true);
        budgetNegotiation.setRejectedByFinancialManager(false);
        return budgetNegotiationRepository.save(budgetNegotiation);
    }

    public BudgetNegotiation rejectBudgetNegotiationByFMById(Long id) {
        Optional<BudgetNegotiation> budgetNegotiationOptional = budgetNegotiationRepository.findById(id);
        if (budgetNegotiationOptional.isEmpty()) {
            throw new RuntimeException("budget negotiation not found!");
        }
        BudgetNegotiation budgetNegotiation = budgetNegotiationOptional.get();
        //set approved to true
        budgetNegotiation.setApprovedByFinancialManager(false);
        budgetNegotiation.setRejectedByFinancialManager(true);
        return budgetNegotiationRepository.save(budgetNegotiation);
    }
}
