package com.example.demo_department_account_bai_thi.repository;

import com.example.demo_department_account_bai_thi.entity.Managelogin;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageLoginRepository extends JpaRepository<Managelogin, Integer> {
}
