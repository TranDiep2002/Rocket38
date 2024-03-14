package com.example.jwt_demo_vnpt.security;

import com.example.jwt_demo_vnpt.entity.Roles;
import com.example.jwt_demo_vnpt.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CustomerUserDetail implements UserDetails {
    private int userId;
    private String userName;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
    private boolean userStatus;
    private Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
// Map từ thông tin của user chuyển sang thông tin của userdetail
    public static  CustomerUserDetail mapUserToUserDetail(Users users){
        // lấy các quyền từ đối tượng user
        List<GrantedAuthority> listAuthorities = users.getListRoles().stream()
                .map(roles -> new SimpleGrantedAuthority("ROLE_"+ roles.getRoleName()))
                .collect(Collectors.toList());

        // cách viết 2
      /*  List<GrantedAuthority> lst = new ArrayList<>();
        for (Roles roles:users.getListRoles()){
            SimpleGrantedAuthority simp= new SimpleGrantedAuthority(roles.getRoleName().name());
            lst.add(simp);
        }
        listAuthorities = lst;
       */
        // trả về đối tượng customeruserdetail
        return new CustomerUserDetail(
                users.getUserId(),
                users.getUserName(),
                users.getPassWord(),
                users.getEmail(),
                users.getPhone(),
                users.isUserStatus(),
                listAuthorities
        );
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
