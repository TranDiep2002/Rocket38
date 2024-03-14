package com.example.jwt_demo_vnpt.security;

import com.example.jwt_demo_vnpt.entity.Users;
import com.example.jwt_demo_vnpt.repository.UserRepository;
import com.example.jwt_demo_vnpt.repuest.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomerUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userRepo.findByUserName(username);
        if(users==null){
            throw new UsernameNotFoundException("user not found ");
        }

        return CustomerUserDetail.mapUserToUserDetail(users);
    }
}
