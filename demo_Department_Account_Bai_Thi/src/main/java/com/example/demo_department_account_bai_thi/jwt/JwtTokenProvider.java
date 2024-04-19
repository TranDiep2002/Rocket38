package com.example.demo_department_account_bai_thi.jwt;

import com.example.demo_department_account_bai_thi.Service.AccountDetail;
import io.jsonwebtoken.*;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    @Value("ThucTap")
    private String JWT_SECRET;
    @Value("6000000")
    private int JWT_EXPIRATION;

    // tạo jwt từ thông tin của user
    public  String generateToken(AccountDetail accountDetail){
        Date now = new Date();
        // tính thời gian hết hiệu lực
        Date dateExpire = new Date(now.getTime()+JWT_EXPIRATION);
        // tạo chuỗi jwt
        return Jwts.builder().setSubject(accountDetail.getUsername())
                .setIssuedAt(now)
                .setExpiration(dateExpire)
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact();
    }
    // từ jwt lấy lại thông tin account
    public String getUserNameFromJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET)
                .parseClaimsJws(token).getBody();

        return claims.getSubject();
    }
    // validate token
    public boolean ValidateToken(String token){
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
            // kiểm tra xem token có hết hạn chưa
            Date expiration = claims.getExpiration();
            Date now = new Date();
            if(expiration.before(now)){
                log.error("Expired JWT Token");
                return false;
            }
            // kiểm tra xem token có đúng chữ kí không
            String username = claims.getSubject();
            if(username==null||username.isEmpty()){
                log.error("JWT claims String is emty");
                return false;
            }
            return true;
        }catch (MalformedJwtException ex){
            log.error("Invalid JWT Token");
        }catch (UnsupportedJwtException ex){
            log.error("Unsupported JWT Token");
        }catch (IllegalArgumentException ex){
            log.error("JWT claims String is empty");
        }catch (ExpiredJwtException ex){
            log.error("Expired JWT Token");
        }

        return false;
    }
}
