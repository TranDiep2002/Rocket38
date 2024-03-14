package com.example.jwt_demo_vnpt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Users")
@Data // gồm set , get , constructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;
    @Column(name = "UserName",unique = true,nullable = false)
    private String userName;
    @Column(name = "Password", nullable = false)
    private String passWord;
    @Column(name="Created")
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date cretaed;
    @Column(name = "Email",nullable = false,unique = true)
    private  String email;
    @Column(name="Phone")
    private String phone;
    @Column(name="Status")
    private boolean userStatus;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Role",joinColumns = @JoinColumn(name = "UserId"),
    inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private Set<Roles> listRoles= new HashSet<>();
}
