package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.AppUser;
import com.SEP.BusinessManagementSystem.Entity.CustomerServiceOfficer;
import com.SEP.BusinessManagementSystem.Service.CustomerServiceOfficerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final AppUserService appUserService;

    public MyUserDetailsService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try{
            AppUser appUser = appUserService.findByEmail(username);
            return new User(appUser.getEmail(), appUser.getPassword(), appUser.getAuthorityRoles());
        }
        catch(RuntimeException e){
            throw new UsernameNotFoundException("Username not found");
        }
    }
}