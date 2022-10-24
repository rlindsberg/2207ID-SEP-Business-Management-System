package com.SEP.BusinessManagementSystem.Entity;

import com.SEP.BusinessManagementSystem.Utility.CustomerServiceOfficerClassSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonSerialize(using = CustomerServiceOfficerClassSerializer.class)
public class CustomerServiceOfficer {
    public CustomerServiceOfficer() {
    }

    public CustomerServiceOfficer(AppUser userAsAppUser) {
        this.userAsAppUser = userAsAppUser;
    }

    @Id
    @SequenceGenerator(name="MySequence", sequenceName = "MySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MySequence")
    private Long id;

    @OneToOne
    @JoinColumn(name = "appUser_id")
    @JsonProperty("user")
    private AppUser userAsAppUser;



}
