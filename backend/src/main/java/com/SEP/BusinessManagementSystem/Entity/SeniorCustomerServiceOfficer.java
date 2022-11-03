package com.SEP.BusinessManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class SeniorCustomerServiceOfficer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "first_name")
    @NotNull(message = "Firstname can't be null")
    private String firstname;

    @Column(name = "last_name")
    @NotNull(message = "Lastname can't be null")
    private String lastname;

    @Email(message = "Email has incorrect formatting")
    @NotNull(message = "Email can't be null")
    private String email;

    @NotNull(message = "Password can't be null")
    private String password;

    @JsonIgnore
    private String role = "TEAMLEAD";

    @OneToMany(mappedBy = "seniorCustomerServiceOfficer")
    private Set<CustomerServiceOfficer> customerServiceOfficers;

    protected SeniorCustomerServiceOfficer() {
    }

    public SeniorCustomerServiceOfficer(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public Set<SimpleGrantedAuthority> getRole(){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }
}