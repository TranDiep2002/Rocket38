package com.example.jwt_demo_vnpt.repository;

import com.example.jwt_demo_vnpt.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Roles,Integer> {
    Optional<Roles> findByRoleName(String roleName);
}
