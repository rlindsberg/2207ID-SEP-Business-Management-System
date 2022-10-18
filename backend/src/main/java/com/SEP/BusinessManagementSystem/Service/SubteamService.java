package com.SEP.BusinessManagementSystem.Service;


import com.SEP.BusinessManagementSystem.Entity.Subteam;
import com.SEP.BusinessManagementSystem.Repository.SubteamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SubteamService {
    private final SubteamRepository subteamRepository;


    @Autowired
    public SubteamService(SubteamRepository subteamRepository) {
        this.subteamRepository = subteamRepository;
    }

    public Subteam getSubteamById(Long Id){
        Optional<Subteam> subteamOptional = subteamRepository.findById(Id);
        if (subteamOptional.isEmpty()) {
            throw new RuntimeException("subteam not found!");
        }
        return subteamOptional.get();
    }

    // do we need to create a new subteam??
    public Subteam createNewSubteam(Long Id, Subteam subteamDetails) {
        subteamDetails.setId(Id);
        return subteamRepository.save(subteamDetails);
    }


}