package com.example.demo_department_account_bai_thi.Service;

import com.example.demo_department_account_bai_thi.dto.AccountDTO;
import com.example.demo_department_account_bai_thi.dto.AccountDTO_Login;
import com.example.demo_department_account_bai_thi.entity.Account;
import com.example.demo_department_account_bai_thi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

// nếu ko có service thì khi chạy spring sẽ không tìm thấy hàm load bên dưới
@Service
public class AccountServiceImplm implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Account> opaccount= accountRepository.findByUsername(username);
//        if(opaccount.isEmpty()){
//            throw  new UsernameNotFoundException("không tìm thấy account có tên :"+username);
//        }
//        Account account= opaccount.get();
//        // User ở đây sẽ không hiện lên màn hình mà sẽ do spring quản lý: Collections.emtyList() là
//       // ai đăng nhập là user/admin đều có thể vào đc :return new User(username, account.getPassword(), Collections.emptyList());
//        //return  new User(username,account.getPassword(), AuthorityUtils.createAuthorityList(opaccount.get().getRole()));
//        return  null;

        Account account = accountRepository.findByUsername(username);
        AccountDTO_Login accountDTO= new AccountDTO_Login();
        accountDTO.setId(account.getId());
        accountDTO.setUsername(account.getUsername());
        accountDTO.setFullname(account.getFullname());
        accountDTO.setPassword(account.getPassword());
        accountDTO.setDepartmentName(account.getDepartment().toString());
        accountDTO.setLst(account.getLstRoles().stream().toList());
        if(accountDTO==null){
            throw  new UsernameNotFoundException("username not found");
        }
        return AccountDetail.mapAccounttoAccountDetail(accountDTO);
    }
}
