package com.SEP.BusinessManagementSystem.Repository;

import com.SEP.BusinessManagementSystem.Entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
