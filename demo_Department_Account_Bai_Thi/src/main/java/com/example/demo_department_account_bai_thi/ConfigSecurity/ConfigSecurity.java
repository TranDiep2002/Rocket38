package com.example.demo_department_account_bai_thi.ConfigSecurity;

import com.example.demo_department_account_bai_thi.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigSecurity {
@Autowired
    private AccountService accountService;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
}
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception{
        httpSecurity.cors();
        httpSecurity.csrf().disable();
        // ai cx có thể truy cập đc với đường link account, department
        httpSecurity.authorizeRequests().requestMatchers("/account","/department").permitAll();
        // với đường link có admin , thì chỉ admin ms truy cập đc , nếu mk muốn thêm manager cx có thể vào
        // /admin/** : ** ở đây là chỉ cần đg lik có /admin/... thì .. đằng sau là bất kì gì đều admin ms có thể truy cập vào đc
        httpSecurity.authorizeRequests().requestMatchers("/admin/**").hasAnyRole("ADMIN","MANAGER"); // ROLE_ADMIN : đaay là cách viết đầy đủ
        // các trường hợp còn lại thì cần phải đăng nhập ví dụ : /department/{id} cx cần đăng nhập ms xem đc
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        // httpBasic : là chúng ta có thể đăng nhập dạng thuần như trong postman
        // còn nếu để formLogin , thì khi đăng nhập bằng posman nó sẽ ko nhận
        // vì nó chỉ nhận dữ liệu đăng nhập từ form
        httpSecurity.httpBasic();
        return  httpSecurity.build();
    }
}
