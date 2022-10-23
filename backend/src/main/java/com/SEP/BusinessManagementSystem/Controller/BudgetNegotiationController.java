package com.SEP.BusinessManagementSystem.Controller;

import com.SEP.BusinessManagementSystem.Entity.BudgetNegotiation;
import com.SEP.BusinessManagementSystem.Service.BudgetNegotiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/budget-negotiation")
public class BudgetNegotiationController {
    private final BudgetNegotiationService budgetNegotiationService;

    @Autowired
    public BudgetNegotiationController(BudgetNegotiationService budgetNegotiationService) {
        this.budgetNegotiationService = budgetNegotiationService;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getBudgetNegotiationById(@PathVariable Long id){
        return ResponseEntity.ok().body(budgetNegotiationService.getBudgetNegotiationById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewNegotiationBudget(@RequestBody BudgetNegotiation budgetNegotiationDetails) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("budget-negotiation/create").toUriString());
        return ResponseEntity.created(uri).body(budgetNegotiationService.createNewBudgetNegotiation(budgetNegotiationDetails));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateExpectedBudget(@PathVariable(value = "id") Long id, @RequestBody BudgetNegotiation budgetNegotiationDetails) {
        int expectedBudgetToBeUpdated = budgetNegotiationDetails.getExpectedBudget();
        return ResponseEntity.ok().body(budgetNegotiationService.updateExpectedBudget(id, expectedBudgetToBeUpdated));
    }


    // Financial Manager
    @PutMapping("/approve/{id}")
    public ResponseEntity<?> approveBudgetNegotiationByFMById(@PathVariable Long id){
        return ResponseEntity.ok().body(budgetNegotiationService.approveBudgetNegotiationByFMById(id));
    }

    // Financial Manager
    @PutMapping("/reject/{id}")
    public ResponseEntity<?> rejectBudgetNegotiationByFMById(@PathVariable Long id){
        return ResponseEntity.ok().body(budgetNegotiationService.rejectBudgetNegotiationByFMById(id));
    }


}
