package com.SEP.BusinessManagementSystem.Repository;

import com.SEP.BusinessManagementSystem.Entity.SeniorCustomerServiceOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeniorCustomerServiceOfficerRepository extends JpaRepository<SeniorCustomerServiceOfficer, Long> {
    Optional<SeniorCustomerServiceOfficer> findByEmail(String username);
}