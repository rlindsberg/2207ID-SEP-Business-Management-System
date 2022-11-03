package com.SEP.BusinessManagementSystem.Repository;

import com.SEP.BusinessManagementSystem.Entity.CustomerServiceOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerServiceOfficerRepository extends JpaRepository<CustomerServiceOfficer, Long> {
    Optional<CustomerServiceOfficer> findByEmail(String username);
}