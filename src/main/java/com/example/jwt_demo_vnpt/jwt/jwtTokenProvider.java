package com.example.jwt_demo_vnpt.jwt;


import com.example.jwt_demo_vnpt.security.CustomerUserDetail;
import io.jsonwebtoken.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component // khi ứng dụng đẩy dữ liệu lên sẽ được nạp vào cnt
@Slf4j // ghi log của lombok
public class jwtTokenProvider {
    @Value("THucTap")
    private String JWT_SECRET;
    @Value("6000000")
    private int JWT_EXPIRATION;

    // tạo jwt từ thông tin của user
    public String generateToken(CustomerUserDetail customerUserDetail){
        Date now = new Date();
        // tính thòi gian hết hiệu lực = lấy thời gian hiện tại cộng với thời gian đc phép đăng nhập
        Date dateExpired = new Date(now.getTime()+JWT_EXPIRATION);
        // tạo chuỗi jwt từ username
        return Jwts.builder().setSubject(customerUserDetail.getUsername())    // setSubject ở đây là phương thức đc sử dụng từ thư viện JSON : để đặt nội dung chính của JWT là username
                .setIssuedAt(now) // set ngày có hiệu lực là ngày hiện tại
                .setExpiration(dateExpired)// set ngày hết hạn bằng dateExpired
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET) // cơ chế  giải thuật(HS512) để mã hóa theo key là JWT_SECRET
                .compact(); // đưa ra kết quả
    }

    // từ jwt lấy lại thông tin của user
    public String getUserNameFromJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET)
                .parseClaimsJws(token).getBody(); // mở khóa với key JWT_SECRET sau đó parser đoạn string token và lấy ra body : ở đây là username
                // trả lại thông tin user
                return  claims.getSubject(); // getSubject là phương thức để lấy ra username từ JWT
    }
    // validate token : còn hạn hay ko
    public boolean ValidateToken(String token){
        try {
            Jwts.parser().setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token);
        }catch (MalformedJwtException ex){
            log.error("Invalid JWT Token");
        }catch (ExpiredJwtException ex){
            log.error("Expired JWT Token");
        }catch (UnsupportedJwtException ex){
            log.error("Unsupported JWT Token");
        }catch (IllegalArgumentException ex){
            log.error("JWT claims String is emty");
        }
            return false;
    }
}
