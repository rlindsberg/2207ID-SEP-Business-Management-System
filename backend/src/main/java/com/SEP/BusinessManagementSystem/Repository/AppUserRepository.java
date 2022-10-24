package com.SEP.BusinessManagementSystem.Repository;

import com.SEP.BusinessManagementSystem.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface is responsible for database calls regarding the AppUsers.
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String username);
}