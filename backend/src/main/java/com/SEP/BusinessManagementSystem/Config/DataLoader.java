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

    public DataLoader(CustomerServiceOfficerRepository customerServiceOfficerRepository, SeniorCustomerServiceOfficerRepository seniorCustomerServiceOfficerRepository) {
        this.customerServiceOfficerRepository = customerServiceOfficerRepository;
        this.seniorCustomerServiceOfficerRepository = seniorCustomerServiceOfficerRepository;
    }

    public void run(String... args) throws Exception {
        SeniorCustomerServiceOfficer seniorCustomerServiceOfficer1 = new SeniorCustomerServiceOfficer("Jim", "Halpert", "jimhalpert@dm.com", "1234");

        CustomerServiceOfficer customerServiceOfficer1 = new CustomerServiceOfficer("Michael", "Scott", "michaelscott@dm.com", "1234", seniorCustomerServiceOfficer1);

        seniorCustomerServiceOfficerRepository.save(seniorCustomerServiceOfficer1);
        customerServiceOfficerRepository.save(customerServiceOfficer1);
    }
}
