package com.SEP.BusinessManagementSystem.Entity;

import com.SEP.BusinessManagementSystem.Utility.RolesFieldSerializerInClassAppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * This model class contains application-user data and is stored in the database.
 */
@Entity
@Getter
@Setter
@JsonRootName("User")
public class AppUser {
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

    @JsonIgnore
    @NotNull(message = "Password can't be null")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonSerialize(using = RolesFieldSerializerInClassAppUser.class)
    Set<Role> roles = new HashSet<>();


    @JsonIgnore
    @OneToOne(mappedBy = "userAsAppUser")
    private CustomerServiceOfficer userAsCustomerServiceOfficer;

    public AppUser(String firstname, String lastname, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = firstname.concat(lastname).concat("@dm.com").toLowerCase();
        this.password = password;
    }

    public AppUser() {
    }

    /**
     * This method returns the AppUser's role, and is used for Spring Security and JWT authorization.
     * @return Set <SimpleGrantedAuthority> - The roles of the AppUser.
     */
    @JsonIgnore
    public Set<SimpleGrantedAuthority> getAuthorityRoles(){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        return authorities;
    }
}