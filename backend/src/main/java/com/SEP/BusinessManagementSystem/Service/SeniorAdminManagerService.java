package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.SeniorAdminManager;
import com.SEP.BusinessManagementSystem.Repository.SeniorAdminManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeniorAdminManagerService {

    @Autowired
    private SeniorAdminManagerRepository seniorAdminManagerRepository;

    public List<SeniorAdminManager> findAll(){
        return seniorAdminManagerRepository.findAll();
    }

    public Optional<SeniorAdminManager> findById(Long id){
        return seniorAdminManagerRepository.findById(id);
    }

    public SeniorAdminManager save(SeniorAdminManager seniorAdminManager){
        return seniorAdminManagerRepository.save(seniorAdminManager);
    }

    /**
     * Id should  be saved thus replacing the values
     */
    public SeniorAdminManager updateSeniorAdminManager(SeniorAdminManager updatedSCSO, SeniorAdminManager seniorAdminManager){
        seniorAdminManager.setFirstname(updatedSCSO.getFirstname());
        seniorAdminManager.setLastname(updatedSCSO.getLastname());
        seniorAdminManager.setEmail(updatedSCSO.getEmail());
        seniorAdminManager.setPassword(updatedSCSO.getPassword());
        return save(seniorAdminManager);
    }

    public void deleteSeniorAdminManager(Long id){
        seniorAdminManagerRepository.deleteById(id);
    }

    public Optional<SeniorAdminManager> findByEmail(String username) {
        return seniorAdminManagerRepository.findByEmail(username);
    }
}
