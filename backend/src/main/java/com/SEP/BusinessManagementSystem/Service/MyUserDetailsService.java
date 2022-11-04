package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.CustomerServiceOfficer;
import com.SEP.BusinessManagementSystem.Entity.SeniorAdminManager;
import com.SEP.BusinessManagementSystem.Entity.SeniorCustomerServiceOfficer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final CustomerServiceOfficerService customerServiceOfficerService;
    private final SeniorCustomerServiceOfficerService seniorCustomerServiceOfficerService;
    private final SeniorAdminManagerService seniorAdminManagerService;

    public MyUserDetailsService(CustomerServiceOfficerService customerServiceOfficerService,  SeniorCustomerServiceOfficerService seniorCustomerServiceOfficerService, SeniorAdminManagerService seniorAdminManagerService) {
        this.customerServiceOfficerService = customerServiceOfficerService;
        this.seniorCustomerServiceOfficerService = seniorCustomerServiceOfficerService;
        this.seniorAdminManagerService = seniorAdminManagerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CustomerServiceOfficer> customerServiceOfficer = customerServiceOfficerService.findByEmail(username);
        if(customerServiceOfficer.isPresent()) {
            return new User(customerServiceOfficer.get().getEmail(), customerServiceOfficer.get().getPassword(), customerServiceOfficer.get().getRole());
        }

        Optional<SeniorCustomerServiceOfficer> seniorCustomerServiceOfficer = seniorCustomerServiceOfficerService.findByEmail(username);
        if(seniorCustomerServiceOfficer.isPresent()){
            return new User(seniorCustomerServiceOfficer.get().getEmail(), seniorCustomerServiceOfficer.get().getPassword(), seniorCustomerServiceOfficer.get().getRole());
        }

        Optional<SeniorAdminManager> seniorAdminManager = seniorAdminManagerService.findByEmail(username);
        if(seniorAdminManager.isPresent()){
            return new User(seniorAdminManager.get().getEmail(), seniorAdminManager.get().getPassword(), seniorAdminManager.get().getRole());
        }

        throw new UsernameNotFoundException("Username not found");
    }
}