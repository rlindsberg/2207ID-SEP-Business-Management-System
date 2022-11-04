package com.SEP.BusinessManagementSystem.Repository;

import com.SEP.BusinessManagementSystem.Entity.SeniorAdminManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeniorAdminManagerRepository extends JpaRepository<SeniorAdminManager, Long> {
    Optional<SeniorAdminManager> findByEmail(String username);
}
