package com.example.demo_department_account_bai_thi.jwt;

import com.example.demo_department_account_bai_thi.Service.AccountDetail;
import com.example.demo_department_account_bai_thi.Service.AccountService;
import com.example.demo_department_account_bai_thi.Service.AccountServiceImplm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class JwtAthenticationFillter extends OncePerRequestFilter {

    @Bean
    public PasswordEncoder passwordEncoder(){return  new BCryptPasswordEncoder();}
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AccountService accountService;

    private String getJWTFromRequest(HttpServletRequest httpServletRequest){
        String bearerToken = httpServletRequest.getHeader("Authorization");
        // kiểm tra author có chứa thông tin jwt?
        if(StringUtils.hasText(bearerToken)&&bearerToken.startsWith("Bearer")){
            return bearerToken.substring(7);
        }
        return null;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJWTFromRequest(request);
            if(StringUtils.hasText(jwt)&&jwtTokenProvider.ValidateToken(jwt)){
                String username = jwtTokenProvider.getUserNameFromJWT(jwt);
                AccountDetail accountDetail = (AccountDetail) accountService.loadUserByUsername(username);
                if(accountDetail!=null){
                    UsernamePasswordAuthenticationToken authenticationToken
                            =new UsernamePasswordAuthenticationToken(accountDetail,null,accountDetail.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }

            }
        catch (Exception e){
            log.error("fail on set user authentication",e);
        }
        filterChain.doFilter(request,response);
    }
}
