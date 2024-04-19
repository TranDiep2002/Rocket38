package com.example.demo_department_account_bai_thi.repository;

import com.example.demo_department_account_bai_thi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
   // Optional<Account> findByUsername(String username);
    Account findByUsername(String username);

    @Query(value = " from Account where username like %:name%")
//    Optional TimKiemAccount(String name);
    List<Account> TimKiemAccount(String name);
}
