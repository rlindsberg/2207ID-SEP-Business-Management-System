package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.AppUser;
import com.SEP.BusinessManagementSystem.Entity.CustomerServiceOfficer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceOfficerService {
    private final AppUserService appUserService;

    public CustomerServiceOfficerService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    public CustomerServiceOfficer findById(Long id){
        CustomerServiceOfficer customerServiceOfficer;
        try{
            customerServiceOfficer = appUserService.findById(id).getUserAsCustomerServiceOfficer();

            if (customerServiceOfficer == null) {
                throw new RuntimeException("Customer service officer not found");
            }
        }
        catch (RuntimeException e) {
            throw new RuntimeException("Customer service officer not found");
        }

        return customerServiceOfficer;
    }

    public CustomerServiceOfficer findByEmail(String username) {
        try{
            AppUser appUser = appUserService.findByEmail(username);
            return appUser.getUserAsCustomerServiceOfficer();
        }
        catch (RuntimeException e){
            throw new RuntimeException("Customer service officer not found");
        }
    }
}
