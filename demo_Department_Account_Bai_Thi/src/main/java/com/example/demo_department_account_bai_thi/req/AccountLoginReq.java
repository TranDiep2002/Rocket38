package com.example.demo_department_account_bai_thi.req;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountLoginReq {
    private String password;
    private String username;
}
