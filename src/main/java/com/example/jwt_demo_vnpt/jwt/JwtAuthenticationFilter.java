package com.example.jwt_demo_vnpt.jwt;

import com.example.jwt_demo_vnpt.security.CustomerUserDetail;
import com.example.jwt_demo_vnpt.security.CustomerUserDetailService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private jwtTokenProvider jwtTokenProvider;
    @Autowired
    private CustomerUserDetailService customerUserDetailService;
    private String getJWTFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        // kiem tra xem header Authorization co chuaw thong tin JWT hay ko
        if(StringUtils.hasText(bearerToken)&&bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7); // lấy ra chuỗi jwt và cắt bắt đầu từ kí tự thứ 7 , vì phần đầu là header "Bearer"
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            String jwt = getJWTFromRequest(request);
            if (StringUtils.hasText(jwt) && jwtTokenProvider.ValidateToken(jwt)) {
                String userName = jwtTokenProvider.getUserNameFromJWT(jwt);
                UserDetails userDetails = customerUserDetailService.loadUserByUsername(userName);
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authenticationToken
                            = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            } else if ("/login".equals(request.getRequestURI()) && HttpMethod.POST.matches(request.getMethod())) {
                // Xử lý đăng nhập thông thường
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                UserDetails userDetails = customerUserDetailService.loadUserByUsername(username);
                if (userDetails != null && passwordEncoder().matches(password, userDetails.getPassword())) {
                    // Nếu xác thực thành công, tạo JWT token
                    String token = jwtTokenProvider.generateToken((CustomerUserDetail) userDetails);

                    // Trả về token cho người dùng
                    response.setContentType("text/plain");
                    response.getWriter().write(token);
                    return;
                } else {
                    // Xác thực không thành công, trả về lỗi
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("Authentication failed");
                    return;
                }
            }
        } catch (Exception e) {
            log.error("fail on set user authentication", e);
        }
        filterChain.doFilter(request,response);
    }
}
