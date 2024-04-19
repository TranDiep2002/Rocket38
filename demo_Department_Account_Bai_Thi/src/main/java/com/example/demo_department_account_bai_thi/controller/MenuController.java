package com.example.demo_department_account_bai_thi.controller;

import com.example.demo_department_account_bai_thi.entity.Account;
import com.example.demo_department_account_bai_thi.entity.Menu;
import com.example.demo_department_account_bai_thi.entity.Role;
import com.example.demo_department_account_bai_thi.repository.AccountRepository;
import com.example.demo_department_account_bai_thi.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MenuController {

    @Autowired
    private MenuRepository menuRepo;
    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("/menu")
    public  ResponseEntity<?> getAllMenu(){
        List<Menu> menus = menuRepo.findAll();
        return  ResponseEntity.ok(menus);
    }
    @GetMapping("/menu/{name}")
    public  ResponseEntity<?> getMenuUserName(@PathVariable String  name){
        Account account = accountRepository.findByUsername(name);
        if(account!=null){
//            List<Menu> menus = menuRepo.findByLstRoles( account.getLstRoles());
            List<Menu> menus = menuRepo.findAll();
            return ResponseEntity.ok(menus);
        }
        return ResponseEntity.ok("khong tim thay account"+name);
    }
}
