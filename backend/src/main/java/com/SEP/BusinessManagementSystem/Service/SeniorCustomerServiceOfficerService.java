package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.SeniorCustomerServiceOfficer;
import com.SEP.BusinessManagementSystem.Repository.SeniorCustomerServiceOfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeniorCustomerServiceOfficerService {

    @Autowired
    private SeniorCustomerServiceOfficerRepository seniorCustomerServiceOfficerRepository;

    public List<SeniorCustomerServiceOfficer> findAll(){
        return seniorCustomerServiceOfficerRepository.findAll();
    }

    public Optional<SeniorCustomerServiceOfficer> findById(Long id){
        return seniorCustomerServiceOfficerRepository.findById(id);
    }

    public SeniorCustomerServiceOfficer save(SeniorCustomerServiceOfficer seniorCustomerServiceOfficer){
        return seniorCustomerServiceOfficerRepository.save(seniorCustomerServiceOfficer);
    }

    /**
     * Id should  be saved thus replacing the values
     */
    public SeniorCustomerServiceOfficer updateSeniorCustomerServiceOfficer(SeniorCustomerServiceOfficer updatedSCSO, SeniorCustomerServiceOfficer seniorCustomerServiceOfficer){
        seniorCustomerServiceOfficer.setFirstname(updatedSCSO.getFirstname());
        seniorCustomerServiceOfficer.setLastname(updatedSCSO.getLastname());
        seniorCustomerServiceOfficer.setEmail(updatedSCSO.getEmail());
        seniorCustomerServiceOfficer.setPassword(updatedSCSO.getPassword());
        return save(seniorCustomerServiceOfficer);
    }

    public void deleteSeniorCustomerServiceOfficer(Long id){
        seniorCustomerServiceOfficerRepository.deleteById(id);
    }

    public Optional<SeniorCustomerServiceOfficer> findByEmail(String username) {
        return seniorCustomerServiceOfficerRepository.findByEmail(username);
    }
}