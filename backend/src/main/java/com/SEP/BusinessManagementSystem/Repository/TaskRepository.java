package com.SEP.BusinessManagementSystem.Repository;

import com.SEP.BusinessManagementSystem.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
