package com.example.demo_department_account_bai_thi.ConfigSecurity;

import com.example.demo_department_account_bai_thi.Service.AccountService;
import com.example.demo_department_account_bai_thi.jwt.JwtAthenticationFillter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class ConfigSecurity {
@Autowired
    private JwtAthenticationFillter jwtAthenticationFillter;
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception{
        httpSecurity.cors();
        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests().requestMatchers("/account","/department","/login").permitAll();
        httpSecurity.authorizeRequests().requestMatchers("/admin/**").hasAnyRole("ADMIN","MANAGER"); // ROLE_ADMIN : đaay là cách viết đầy đủ
        httpSecurity.authorizeRequests().anyRequest().authenticated();
//        httpSecurity.httpBasic();
        httpSecurity.addFilterBefore(jwtAthenticationFillter, UsernamePasswordAuthenticationFilter.class);
        return  httpSecurity.build();
    }
}
