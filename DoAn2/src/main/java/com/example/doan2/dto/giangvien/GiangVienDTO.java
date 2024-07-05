package com.example.doan2.dto.giangvien;

import lombok.Data;

import java.util.Date;

@Data
public class GiangVienDTO {
    private Integer id;
    private String maGV;
    private String hoTen;
    private String vaiTro;
    private String email;
    private String soDT;
    private Date ngayTao;
    private Date ngayCapNhat;
    // tên bộ môn
    private String tenBoMon;
}
