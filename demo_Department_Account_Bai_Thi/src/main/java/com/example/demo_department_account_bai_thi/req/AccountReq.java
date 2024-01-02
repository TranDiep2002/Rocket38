package com.example.demo_department_account_bai_thi.req;

import lombok.Data;

@Data
public class AccountReq {
    private String fullname;
    private String username;
    private String password;
    private Integer departmentId;
}
