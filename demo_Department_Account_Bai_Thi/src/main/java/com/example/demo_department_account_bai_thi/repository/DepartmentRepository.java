package com.example.demo_department_account_bai_thi.repository;

import com.example.demo_department_account_bai_thi.entity.Department;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    // quy định: findByDepartmentName (departmentName viết gioongs bên entity nhưng viết hoa chữ cái đầu)
    // = from department where departmentName=:departmentName
Optional<Department> findByDepartmentName(String departmentName);
// nếu dùng cách update theo query như này , thì mk phải khai báo trong lớp DepartmentUpdateReq thêm id của depart
@Query(value = "update Department set departmentName= :departmentName where id= :id")
    void updatedepart(String departmentName,int id);
@Modifying
@Query(value = "delete from Department where id= :id")
    void deleteById(Integer id);
}
