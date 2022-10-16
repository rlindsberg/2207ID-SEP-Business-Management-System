package com.SEP.BusinessManagementSystem.Repository;

import com.SEP.BusinessManagementSystem.Entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query("SELECT r from Request r WHERE r.isApprovedBySCS = true")
    Optional<Request> findRequestByIdByFM(Long id);

    @Query("SELECT r from Request r WHERE r.isApprovedByFinancialManager = true")
    Optional<Request> findRequestByIdByAM(Long id);

    @Query("SELECT r from Request r WHERE r.isReviewedByAdminManager = true")
    Optional<Request> findRequestByIdBySCS(Long id);
}
