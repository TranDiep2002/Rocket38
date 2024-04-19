package com.example.demo_department_account_bai_thi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String fullname;
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Account_Role",joinColumns= @JoinColumn(name = "AccountId"),
    inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private Set<Role> lstRoles = new HashSet<>();
}
