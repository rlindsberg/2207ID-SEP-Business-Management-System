package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.Task;
import com.SEP.BusinessManagementSystem.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;


    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTaskById(Long Id){
        Optional<Task> taskOptional = taskRepository.findById(Id);
        if (taskOptional.isEmpty()) {
            throw new RuntimeException("Task not found!");
        }
        return taskOptional.get();
    }

    public Task createNewTask(Long Id, Task taskDetails) {
        taskDetails.setId(Id);
        return taskRepository.save(taskDetails);
    }

    public Task updateDueDate(Long taskId, LocalDate dueDate) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isEmpty()) {
            throw new RuntimeException("Task not found!");
        }
        Task task = taskOptional.get();
        task.setDueDate(dueDate);
        return taskRepository.save(task);
    }

    public Task addComment(Long taskId, String comment) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isEmpty()) {
            throw new RuntimeException("Task not found!");
        }
        Task task = taskOptional.get();
        task.setBudgetComment(comment);
        return taskRepository.save(task);
    }
}
