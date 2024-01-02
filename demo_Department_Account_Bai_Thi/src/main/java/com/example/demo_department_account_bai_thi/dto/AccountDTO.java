package com.example.demo_department_account_bai_thi.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private Integer id;
    private String username;
    private String password;
    private String fullname;
    // chú ý departmentName phải giống với bên entity
    private String departmentName;
}

