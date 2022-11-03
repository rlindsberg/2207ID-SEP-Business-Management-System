package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.CustomerServiceOfficer;
import com.SEP.BusinessManagementSystem.Repository.CustomerServiceOfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceOfficerService {

    @Autowired
    private CustomerServiceOfficerRepository customerServiceOfficerRepository;

    public List<CustomerServiceOfficer> findAll(){
        return customerServiceOfficerRepository.findAll();
    }

    public Optional<CustomerServiceOfficer> findById(Long id){
        return customerServiceOfficerRepository.findById(id);
    }

    public CustomerServiceOfficer save(CustomerServiceOfficer customerServiceOfficer){
        return customerServiceOfficerRepository.save(customerServiceOfficer);
    }

    /**
     * Id should  be saved thus replacing the values
     */
    public CustomerServiceOfficer updateCustomerServiceOfficer(CustomerServiceOfficer updatedCustomerServiceOfficer, CustomerServiceOfficer customerServiceOfficer){
        customerServiceOfficer.setFirstname(updatedCustomerServiceOfficer.getFirstname());
        customerServiceOfficer.setLastname(updatedCustomerServiceOfficer.getLastname());
        customerServiceOfficer.setEmail(updatedCustomerServiceOfficer.getEmail());
        customerServiceOfficer.setPassword(updatedCustomerServiceOfficer.getPassword());
        return save(customerServiceOfficer);
    }

    public void deleteCustomerServiceOfficer(Long id){
        customerServiceOfficerRepository.deleteById(id);
    }

    public Optional<CustomerServiceOfficer> findByEmail(String username) {
        return customerServiceOfficerRepository.findByEmail(username);
    }
}