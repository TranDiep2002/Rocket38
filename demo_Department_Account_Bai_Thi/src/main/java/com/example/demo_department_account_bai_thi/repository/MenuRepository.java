package com.example.demo_department_account_bai_thi.repository;

import com.example.demo_department_account_bai_thi.entity.Menu;
import com.example.demo_department_account_bai_thi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {

    @Query("SELECT m FROM Menu m JOIN m.lstRoles r WHERE r IN :roles")
        List<Menu> findByLstRoles(@PathVariable ("roles") Set<Role> roles);


}
