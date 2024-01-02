package com.example.demo_department_account_bai_thi.controller;

import com.example.demo_department_account_bai_thi.dto.AccountDTO;
import com.example.demo_department_account_bai_thi.entity.Account;
import com.example.demo_department_account_bai_thi.entity.Department;
import com.example.demo_department_account_bai_thi.repository.AccountRepository;
import com.example.demo_department_account_bai_thi.repository.DepartmentRepository;
import com.example.demo_department_account_bai_thi.req.AccountReq;
import com.example.demo_department_account_bai_thi.req.AccountUpdateReq;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// cấp quyền truy cập
// không thì sẽ gặp phải lỗi này
//Access to XMLHttpRequest at 'http://localhost:8080/account' from origin 'http://localhost:63342' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.
@CrossOrigin(value = "*")
@RestController
// thêm thông tin lịch sử ( log4j)
@Slf4j
public class AccountController {
    @Autowired
    private AccountRepository accountRepo;
    @Autowired
    private DepartmentRepository departmentRepo;
    @Autowired
    private ModelMapper modelMapper;
//    public AccountController(AccountRepository accountRepo) {
//        this.accountRepo = accountRepo;
//    }

    @GetMapping("account")
    public ResponseEntity<?>getAll(){
        log.info("Get all list of account");
        List<Account> accounts= accountRepo.findAll();

        List<AccountDTO> accountDTOS= modelMapper.map(accounts,new TypeToken<List<AccountDTO>>(){}.getType());
        return ResponseEntity.ok(accountDTOS);
    }
    @GetMapping("admin/account/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Optional<Account> opAccount=accountRepo.findById(id);
        if(opAccount.isEmpty()){
            return new ResponseEntity<>("khong tim thay account", HttpStatus.BAD_REQUEST);
        }
        Account account=opAccount.get();
        AccountDTO accountDTO=modelMapper.map(account,AccountDTO.class);
        return ResponseEntity.ok(accountDTO);
    }
    @PostMapping("account")
    public ResponseEntity<?> CreateAccount(@RequestBody AccountReq accountReq){
        Optional<Account> opaccount= accountRepo.findByUsername(accountReq.getUsername());
        if(opaccount.isPresent()){
            return ResponseEntity.ok("Đã tồn tại account");
        }
        Optional<Department> opdepart= departmentRepo.findById(accountReq.getDepartmentId());
        if(opdepart.isEmpty()){
            return ResponseEntity.ok(" không tìm thấy phòng ban");
        }
        // cách 1 : set giá trị bằng map
//        Account account=modelMapper.map(accountReq,Account.class);
//        account.setId(null);
        // cách 2: set từng giá trị
        Account account=new Account();
        account.setUsername(accountReq.getUsername());
        account.setFullname(accountReq.getFullname());
        account.setPassword(accountReq.getPassword());
        account.setDepartment(opdepart.get());
        accountRepo.save(account);
        return ResponseEntity.ok("tạo account thành công ");
    }
    @PutMapping("account")
    public ResponseEntity<?> updateAccount(@RequestBody AccountUpdateReq accountUpdateReq){
        Optional<Account> opaccount= accountRepo.findById(accountUpdateReq.getId());
        if(opaccount.isPresent()){
            Account account= opaccount.get();
                account.setFullname(accountUpdateReq.getFullname());
                account.setPassword(accountUpdateReq.getPassword());
                account.setUsername(accountUpdateReq.getUsername());
                Optional<Department> optionalDepartment = departmentRepo.findById( accountUpdateReq.getDepartmentId());
                if(optionalDepartment.isEmpty()){
                    return ResponseEntity.ok("department không hợp lệ");
                }else{
                    account.setDepartment(optionalDepartment.get());
                }
                accountRepo.save(account);
                return ResponseEntity.ok(" cập nhật thông tin account thành công ");
        }
        return ResponseEntity.ok(" không tìm thấy account ");
    }
    @DeleteMapping("account/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer id){
        Optional<Account> opAccount= accountRepo.findById(id);
        if(opAccount.isEmpty()){
            return ResponseEntity.ok("không tìm thấy account");
        }
        accountRepo.deleteById(id);
        return ResponseEntity.ok("xóa thành công ");
    }

}

