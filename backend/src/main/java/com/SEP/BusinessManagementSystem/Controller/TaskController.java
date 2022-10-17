package com.SEP.BusinessManagementSystem.Controller;
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


    @GetMapping("/get/{Id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long Id){
        return ResponseEntity.ok().body(taskService.getTaskById(Id));
    }

    @PostMapping("/create/{Id}")
    public ResponseEntity<?> createNewTask(@PathVariable Long Id, @RequestBody Task taskDetails) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("tasks/create").toUriString());
        return ResponseEntity.created(uri).body(taskService.createNewTask(Id, taskDetails));
    }

    /**
     * The PM/SM and subteam should be able to update the task. (Due date for now)
     * @param taskId
     * @param taskDetails
     * @return
     */
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
