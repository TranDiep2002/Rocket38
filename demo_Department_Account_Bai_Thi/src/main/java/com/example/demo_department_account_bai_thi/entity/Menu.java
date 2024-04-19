package com.example.demo_department_account_bai_thi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nameMenu;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Menu_Role",joinColumns= @JoinColumn(name = "MenuId"),
            inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private Set<Role> lstRoles = new HashSet<>();

}
