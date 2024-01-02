package com.example.demo_department_account_bai_thi.Service;

import com.example.demo_department_account_bai_thi.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    // khi extends Userdetail... thì thực chất  trong hàm đã có sẵn 1 hàm của UserDetailsService rồi ,
    // nên chúng ta không cần viết ra

}
