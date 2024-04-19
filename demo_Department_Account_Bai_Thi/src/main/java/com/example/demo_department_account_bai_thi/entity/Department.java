package com.example.demo_department_account_bai_thi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String departmentName;
    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

    public String toString() {
        return "Department{id=" + id + ", departmentName='" + departmentName + "'}";
    }
}

