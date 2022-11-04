package com.SEP.BusinessManagementSystem.Config;

import com.SEP.BusinessManagementSystem.Entity.*;
import com.SEP.BusinessManagementSystem.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {
    private final CustomerServiceOfficerRepository customerServiceOfficerRepository;
    private final SeniorCustomerServiceOfficerRepository seniorCustomerServiceOfficerRepository;
    private final SeniorAdminManagerRepository seniorAdminManagerRepository;

    public DataLoader(CustomerServiceOfficerRepository customerServiceOfficerRepository, SeniorCustomerServiceOfficerRepository seniorCustomerServiceOfficerRepository, SeniorAdminManagerRepository seniorAdminManagerRepository) {
        this.customerServiceOfficerRepository = customerServiceOfficerRepository;
        this.seniorCustomerServiceOfficerRepository = seniorCustomerServiceOfficerRepository;
        this.seniorAdminManagerRepository = seniorAdminManagerRepository;
    }

    public void run(String... args) throws Exception {
        SeniorCustomerServiceOfficer seniorCustomerServiceOfficer1 = new SeniorCustomerServiceOfficer("Jim", "Halpert", "jimhalpert@dm.com", "1234");

        CustomerServiceOfficer customerServiceOfficer1 = new CustomerServiceOfficer("Michael", "Scott", "michaelscott@dm.com", "1234", seniorCustomerServiceOfficer1);
        SeniorAdminManager seniorAdminManager1 = new SeniorAdminManager("Admin", "Manager", "admin@dm.com", "1234");
        seniorAdminManagerRepository.save(seniorAdminManager1);

        seniorCustomerServiceOfficerRepository.save(seniorCustomerServiceOfficer1);
        customerServiceOfficerRepository.save(customerServiceOfficer1);
    }
}
