package com.SEP.BusinessManagementSystem.Controller;
import com.SEP.BusinessManagementSystem.Entity.BudgetNegotiation;
import com.SEP.BusinessManagementSystem.Entity.HRApplication;
import com.SEP.BusinessManagementSystem.Entity.Task;
import com.SEP.BusinessManagementSystem.Service.HRApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/hr-application")
public class HRApplicationController {
    private final HRApplicationService hrApplicationService;

    @Autowired
    public HRApplicationController(HRApplicationService hrApplicationService) {
        this.hrApplicationService = hrApplicationService;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getHRApplicationById(@PathVariable Long id){
        return ResponseEntity.ok().body(hrApplicationService.getHRApplicationById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewHRApplication(@RequestBody HRApplication hrApplication) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("hr-application/create").toUriString());
        return ResponseEntity.created(uri).body(hrApplicationService.createNewHRApplication(hrApplication));
    }


    @PutMapping("/add-comment/{id}")
    public ResponseEntity<?> addComment(@PathVariable(value = "id") Long id, @RequestBody HRApplication HRApplicationDetails) {
        String commentFromHR = HRApplicationDetails.getCommentFromHR();
        return ResponseEntity.ok().body(hrApplicationService.addComment(id, commentFromHR));
    }
}
