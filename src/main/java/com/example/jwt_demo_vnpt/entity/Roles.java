package com.example.jwt_demo_vnpt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="Roles")
@Data
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleId")
    private int roleId;

    @Column(name = "RoleName")
    private String roleName;
}
