package com.SEP.BusinessManagementSystem.Controller;
import com.SEP.BusinessManagementSystem.Entity.Request;
import com.SEP.BusinessManagementSystem.Entity.Task;
import com.SEP.BusinessManagementSystem.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;


@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id){
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewTask(@RequestBody Task taskDetails) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("tasks/create").toUriString());
        return ResponseEntity.created(uri).body(taskService.createNewTask(taskDetails));
    }
//    @PutMapping("/create")
//    public ResponseEntity<?> createNewRequest(@RequestBody Request requestDetails) {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("requests/create").toUriString());
//        return ResponseEntity.created(uri).body(requestService.createNewRequest(requestDetails));
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDueDate(@PathVariable(value = "id") Long taskId, @RequestBody Task taskDetails) {
        LocalDate dueDateToBeUpdated = taskDetails.getDueDate();
        return ResponseEntity.ok().body(taskService.updateDueDate(taskId, dueDateToBeUpdated));
    }

    @PutMapping("/add-comment/{id}")
    public ResponseEntity<?> addComment(@PathVariable(value = "id") Long taskId, @RequestBody Task taskDetails) {
        String newComment = taskDetails.getBudgetComment();
        return ResponseEntity.ok().body(taskService.addComment(taskId, newComment));
    }
}
