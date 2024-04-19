package com.example.demo_department_account_bai_thi.controller;

import com.example.demo_department_account_bai_thi.dto.ManageLoginDTO;
import com.example.demo_department_account_bai_thi.entity.Managelogin;
import com.example.demo_department_account_bai_thi.repository.ManageLoginRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ManageLoginController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ManageLoginRepository manageLoginRepos;

    @GetMapping("/getallLogin")
    public  ResponseEntity<?> getalllogin(){
       List<Managelogin> lst = manageLoginRepos.findAll();
       List<ManageLoginDTO> manageLoginDTOS = modelMapper.map(lst,new TypeToken<List<Managelogin>>(){}.getType());
       return ResponseEntity.ok(manageLoginDTOS);
    }
}
