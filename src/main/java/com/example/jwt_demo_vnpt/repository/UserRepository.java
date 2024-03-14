package com.example.jwt_demo_vnpt.repository;

import com.example.jwt_demo_vnpt.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
     Users findByUserName(String userName);
     boolean existsByUserName(String userName);
     boolean existsByEmail(String email);
}
