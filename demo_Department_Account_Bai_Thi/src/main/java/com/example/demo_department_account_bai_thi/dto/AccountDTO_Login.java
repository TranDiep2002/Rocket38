package com.example.demo_department_account_bai_thi.dto;

import com.example.demo_department_account_bai_thi.entity.Department;
import com.example.demo_department_account_bai_thi.entity.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AccountDTO_Login {
    private Integer id;
    private String username;
    private String password;
    private String fullname;
    // chú ý departmentName phải giống với bên entity
    private String departmentName;
    List<Role> lst = new ArrayList<>();
}
