package com.SEP.BusinessManagementSystem.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class Client {
    @Id
    private Long id;
    private String name;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(
            name = "clients"
    )
    @JsonIgnore
    private SeniorCustomerServiceOfficer seniorCustomerServiceOfficer;

    @ManyToOne
    @JoinColumn(name = "customer_service_officer_id")
    private CustomerServiceOfficer responsibleCustomerServiceOfficer;

    public CustomerServiceOfficer getCustomerServiceOfficer() {
        return responsibleCustomerServiceOfficer;
    }

    public void setCustomerServiceOfficer(CustomerServiceOfficer customerServiceOfficer) {
        this.responsibleCustomerServiceOfficer = customerServiceOfficer;
    }

    public Client() {
    }

    public Client(Long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
