package com.SEP.BusinessManagementSystem.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    Set<AppUser> users = new HashSet<>();

    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
}