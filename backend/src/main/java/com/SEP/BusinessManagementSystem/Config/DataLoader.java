package com.SEP.BusinessManagementSystem.Config;

import com.SEP.BusinessManagementSystem.Entity.*;
import com.SEP.BusinessManagementSystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

/**
 * This class instantiates the database with data everytime the application starts.
 * (See /src/main/resources/application.properties for DDL configurations)
 */
@Component
public class DataLoader implements CommandLineRunner {

    public static final String PASSWORD = "1234";
    private final RoleRepository roleRepository;
    private final AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public DataLoader( RoleRepository roleRepository, AppUserRepository appUserRepository) {
        this.roleRepository = roleRepository;
        this.appUserRepository = appUserRepository;
    }

    public void run(String... args) throws Exception {
        Role customerServiceOfficerRole = new Role("CUSTOMER_SERVICE");
        Role adminManagerRole = new Role("ADMIN");
        roleRepository.save(customerServiceOfficerRole);
        roleRepository.save(adminManagerRole);

        AppUser appUser1 = new AppUser("Jim", "Halpert", bCryptPasswordEncoder.encode(PASSWORD));
        AppUser appUser2 = new AppUser("Pam", "Beesly", bCryptPasswordEncoder.encode(PASSWORD));

        appUser1.getRoles().add(customerServiceOfficerRole);
        appUser2.getRoles().add(adminManagerRole);

        appUserRepository.save(appUser1);
        appUserRepository.save(appUser2);

    }
}
