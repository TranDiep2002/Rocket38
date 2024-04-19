package com.example.demo_department_account_bai_thi.controller;

import com.example.demo_department_account_bai_thi.Service.AccountDetail;
import com.example.demo_department_account_bai_thi.Service.AccountService;
import com.example.demo_department_account_bai_thi.dto.AccountDTO;
import com.example.demo_department_account_bai_thi.entity.Account;
import com.example.demo_department_account_bai_thi.entity.Department;
import com.example.demo_department_account_bai_thi.entity.Managelogin;
import com.example.demo_department_account_bai_thi.jwt.JwtAthenticationFillter;
import com.example.demo_department_account_bai_thi.jwt.JwtTokenProvider;
import com.example.demo_department_account_bai_thi.repository.AccountRepository;
import com.example.demo_department_account_bai_thi.repository.DepartmentRepository;
import com.example.demo_department_account_bai_thi.repository.ManageLoginRepository;
import com.example.demo_department_account_bai_thi.req.AccountLoginReq;
import com.example.demo_department_account_bai_thi.req.AccountReq;
import com.example.demo_department_account_bai_thi.req.AccountUpdateReq;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccountService accountService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private ManageLoginRepository manageLoginRepo;

//    public AccountController(AccountRepository accountRepo) {
//        this.accountRepo = accountRepo;
//    }

    @PostMapping("login")
    public String Login(@RequestBody AccountLoginReq accountLoginReq){
        AccountDetail accountDetail = (AccountDetail) accountService.loadUserByUsername(accountLoginReq.getUsername());
        if(accountDetail!=null && passwordEncoder.matches(accountLoginReq.getPassword(),accountDetail.getPassword())){

            String token = jwtTokenProvider.generateToken(accountDetail);
            Account account = accountRepo.findByUsername(accountDetail.getUsername());
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String dateString = df.format(date);
            Managelogin managelogin = new Managelogin();
            managelogin.setUserName(accountDetail.getUsername());
            managelogin.setDate(dateString);

            manageLoginRepo.save(managelogin);
            return  token;
        }
        return null;
    }

    @GetMapping("/getrole/{username}")
    public ResponseEntity<?> getRoles(@PathVariable String username){
        Account account = accountRepo.findByUsername(username);
       if(account!=null){
           return ResponseEntity.ok(account.getLstRoles());
       }
       return ResponseEntity.ok("không thay account");
    }
    @GetMapping("/getallaccount/{username}")
    public ResponseEntity<?>getAll(@PathVariable String username){
        Account account= accountRepo.findByUsername(username);
        if(account==null){
            return ResponseEntity.ok("khong tim thay account");
        }
        log.info("Get all list of account");
        List<Account> accounts= accountRepo.findAll();

        List<AccountDTO> accountDTOS= modelMapper.map(accounts,new TypeToken<List<AccountDTO>>(){}.getType());
        return ResponseEntity.ok(accountDTOS);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Optional<Account> opAccount=accountRepo.findById(id);
        if(opAccount.isEmpty()){
            return new ResponseEntity<>("khong tim thay account", HttpStatus.BAD_REQUEST);
        }
        Account account=opAccount.get();
        AccountDTO accountDTO=modelMapper.map(account,AccountDTO.class);
        return ResponseEntity.ok(accountDTO);
    }
    @PostMapping("postaccount")
    public ResponseEntity<?> CreateAccount(@RequestBody AccountReq accountReq){
        Account account1= accountRepo.findByUsername(accountReq.getUsername());
        if(account1!=null){
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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePass = passwordEncoder.encode(accountReq.getPassword());
        Account account=new Account();
        account.setUsername(accountReq.getUsername());
        account.setFullname(accountReq.getFullname());
        account.setPassword(encodePass);
        account.setDepartment(opdepart.get());
        accountRepo.save(account);
        return ResponseEntity.ok("tạo account thành công ");
    }
//    @PutMapping("putaccount")
//    public ResponseEntity<?> updateAccount(@RequestBody AccountUpdateReq accountUpdateReq){
//        Optional<Account> opaccount= accountRepo.findById(accountUpdateReq.getId());
//        if(opaccount.isPresent()){
//            Account account= opaccount.get();
//                account.setFullname(accountUpdateReq.getFullname());
//                account.setPassword(accountUpdateReq.getPassword());
//                account.setUsername(accountUpdateReq.getUsername());
//                Optional<Department> optionalDepartment = departmentRepo.findById( accountUpdateReq.getDepartmentId());
//                if(optionalDepartment.isEmpty()){
//                    return ResponseEntity.ok("department không hợp lệ");
//                }else{
//                    account.setDepartment(optionalDepartment.get());
//                }
//                accountRepo.save(account);
//                return ResponseEntity.ok(" cập nhật thông tin account thành công ");
//        }
//        return ResponseEntity.ok(" không tìm thấy account ");
//    }
    @DeleteMapping("account/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer id){
        Optional<Account> opAccount= accountRepo.findById(id);
        if(opAccount.isEmpty()){
            return ResponseEntity.ok("không tìm thấy account");
        }
        accountRepo.deleteById(id);
        return ResponseEntity.ok("xóa thành công ");
    }

    @GetMapping("/account/name/{name}")
    public ResponseEntity<?> getAccountName(@PathVariable String name){
        List<Account> lst = accountRepo.TimKiemAccount(name);
        if(lst.isEmpty()){
            return ResponseEntity.ok("không tìm thấy account có tên :"+name);
        }
        List<AccountDTO> accountDTOS= modelMapper.map(lst,new TypeToken<List<AccountDTO>>(){}.getType());
        return ResponseEntity.ok(accountDTOS);
    }

    @PutMapping("/putaccount/{id}")
    public ResponseEntity<?> updateAccountReact(@PathVariable int id,@RequestBody AccountUpdateReq accountUpdateReq){
        Optional<Account> opaccount1= accountRepo.findById(id);
        if(opaccount1.isPresent()){
            Account account= opaccount1.get();
            account.setFullname(accountUpdateReq.getFullname());
            account.setPassword(accountUpdateReq.getPassword());
            account.setUsername(accountUpdateReq.getUsername());
            Optional<Department> optionalDepartment = departmentRepo.findByDepartmentName(accountUpdateReq.getDepartmentName());
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

}

