package com.SEP.BusinessManagementSystem.Repository;

import com.SEP.BusinessManagementSystem.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
