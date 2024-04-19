package com.example.demo_department_account_bai_thi.req;

import lombok.Data;

@Data
public class AccountUpdateReq {
    private int id;
    private String fullname;
    private String username;
    private String password;
    private String departmentName;
    private String role;
}
