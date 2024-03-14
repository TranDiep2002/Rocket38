package com.example.jwt_demo_vnpt.controller;

import com.example.jwt_demo_vnpt.repository.UserRepository;
import com.example.jwt_demo_vnpt.repuest.UserReq;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public  ResponseEntity<?> getall(){
    return  new ResponseEntity<>("Login successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserReq userReq){
        System.out.println(userReq);
        Map<String , Object> claims = new HashMap<>();
        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(userReq.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+600*1000))
                .signWith(SignatureAlgorithm.HS512,"THucTap".getBytes()).compact();
        return  token;
    }
}
