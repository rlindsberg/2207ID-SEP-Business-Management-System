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
@Table(name = "CustomerServiceOfficer")
@Getter
@Setter
public class CustomerServiceOfficer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String role = "CUSTOMER_SERVICE";

    // owning side, insert foreign-key column here, so we can use SeniorCustomerServiceOfficer instance attribute to reference this relationship.
    @ManyToOne
    @JoinColumn(
            name = "senior_cs_id"
    )
    @JsonIgnore
    private SeniorCustomerServiceOfficer seniorCustomerServiceOfficer;

    // referencing side, mappedBy picks inverse attribute, used only with bidirectional mappings, 12M, MTM
    // parent table
    @OneToMany(
            mappedBy = "responsibleCustomerServiceOfficer"
    )
    private Set<Client> clients;

    public CustomerServiceOfficer(String firstname, String lastname, String email, String password, SeniorCustomerServiceOfficer seniorCustomerServiceOfficer) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.seniorCustomerServiceOfficer = seniorCustomerServiceOfficer;
    }

    public CustomerServiceOfficer(){

    }

    public Set<SimpleGrantedAuthority> getRole(){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }
}