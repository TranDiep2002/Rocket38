package com.example.demo_department_account_bai_thi.Service;

import com.example.demo_department_account_bai_thi.dto.AccountDTO;
import com.example.demo_department_account_bai_thi.dto.AccountDTO_Login;
import com.example.demo_department_account_bai_thi.entity.Account;
import com.example.demo_department_account_bai_thi.entity.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class AccountDetail implements UserDetails {
    private static ModelMapper modelMapper;
    @Autowired
    public AccountDetail(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    private int id;
    private String username;
    @JsonIgnore
    private String password;
    private String fullname;
    @JsonIgnore
    private String departmentName;
    private Collection<? extends  GrantedAuthority> authorities;

    public AccountDetail(Integer id, String username, String fullname, String password, String departmentName, List<GrantedAuthority> listAuthority) {
            this.id=id;
            this.username= username;
            this.fullname=fullname;
            this.password=password;
            this.departmentName=departmentName;
            authorities=listAuthority;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
// map thông tin của account chuyển sang accountdetail
    public static AccountDetail mapAccounttoAccountDetail(AccountDTO_Login account){

    List<GrantedAuthority> listAuthority = account.getLst().stream()
            .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
            .collect(Collectors.toList());

    return new AccountDetail(
            account.getId(),
            account.getUsername(),
            account.getFullname(),
            account.getPassword(),
            account.getDepartmentName(),
            listAuthority
    );
//        return new AccountDetail(
//                accountDTO.getId(),
//                accountDTO.getFullname(),
//                accountDTO.getUsername(),
//                accountDTO.getPassword(),
//                accountDTO.getDepartmentName(),
//                listAuthority
//
//        );
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
