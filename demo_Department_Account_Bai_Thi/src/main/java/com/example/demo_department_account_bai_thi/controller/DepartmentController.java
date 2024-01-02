package com.example.demo_department_account_bai_thi.controller;

import com.example.demo_department_account_bai_thi.dto.DepartmentDTO;
import com.example.demo_department_account_bai_thi.entity.Account;
import com.example.demo_department_account_bai_thi.entity.Department;
import com.example.demo_department_account_bai_thi.repository.AccountRepository;
import com.example.demo_department_account_bai_thi.repository.DepartmentRepository;
import com.example.demo_department_account_bai_thi.req.DepartmentCreateReq;
import com.example.demo_department_account_bai_thi.req.DepartmentUpdateReq;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
// cấp quyền truy cập
@CrossOrigin(value = "*")
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("department")
    public ResponseEntity<?> getAll(){
        List<Department> departments= departmentRepo.findAll();
        List<DepartmentDTO> departmentDTOS= modelMapper.map(departments,new TypeToken<List<DepartmentDTO>>(){}.getType());
        return ResponseEntity.ok(departmentDTOS);
    }
    @GetMapping("department/{pId}")
    public ResponseEntity<?> getById(@PathVariable Integer pId){

        Optional<Department> opDepartment = departmentRepo.findById(pId);
        if(opDepartment.isEmpty()){
            return new ResponseEntity<>("khong tim thay phong ban", HttpStatus.BAD_REQUEST);
        }
        Department department=opDepartment.get();
        DepartmentDTO departmentDTO= modelMapper.map(department,DepartmentDTO.class);
        return  ResponseEntity.ok(departmentDTO);
    }
    @PostMapping("department")
    public ResponseEntity<?> create(@RequestBody DepartmentCreateReq departmentCreateReq){
        // xử lý trung
        Optional<Department> optionalDepartment= departmentRepo.findByDepartmentName(departmentCreateReq.getDepartmentName());
        if(optionalDepartment.isPresent()){
            return ResponseEntity.ok("đã tồn tại phòng ban");
        }
        Department department= modelMapper.map(departmentCreateReq,Department.class);
        departmentRepo.save(department);
        return ResponseEntity.ok("Create successfully");

    }
    @PutMapping("department/{id}")
    public  ResponseEntity<?> update( @PathVariable Integer id,
            @RequestBody DepartmentUpdateReq departmentUpdateReq){
        Optional<Department> opDepart= departmentRepo.findById(id);
        if(opDepart.isPresent()){
            Department department=opDepart.get();
            department.setDepartmentName(departmentUpdateReq.getDepartmentName());
            departmentRepo.save(department);
            return  ResponseEntity.ok("update success");
        }else
        {
            return ResponseEntity.ok("không tìm thấy department :"+departmentUpdateReq.getDepartmentName());
        }
    }
    @DeleteMapping("admin/department/{pId}")
    public ResponseEntity<?> delete(@PathVariable Integer pId){
        Optional<Department> optionalDepartment= departmentRepo.findById(pId);
        if(optionalDepartment.isPresent()){
            departmentRepo.deleteById(pId);
            return ResponseEntity.ok("xóa thành công");
        }
        return ResponseEntity.ok("không tìm thấy department ");
    }

}
