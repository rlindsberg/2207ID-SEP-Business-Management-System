package com.SEP.BusinessManagementSystem.Service;


import com.SEP.BusinessManagementSystem.Entity.AppUser;
import com.SEP.BusinessManagementSystem.Entity.Role;
import com.SEP.BusinessManagementSystem.Repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> findAll() {
        return this.appUserRepository.findAll();
    }

    public AppUser findById(Long id){
        Optional<AppUser> appUser = appUserRepository.findById(id);
        if (appUser.isEmpty())
            throw new RuntimeException("AppUser id: " + id + " not found");
        return appUser.get();
    }

    public AppUser findByEmail(String username) {
        Optional<AppUser> appUser = appUserRepository.findByEmail(username);
        if (appUser.isEmpty())
            throw new RuntimeException("AppUser username: " + username + " not found");
        return appUser.get();
    }

    public Set<String> getRoleNames(AppUser appUser){
        Set<String> roleNames = new HashSet<>();
        for(Role role : appUser.getRoles()){
            roleNames.add(role.getName());
        }
        return roleNames;
    }
}