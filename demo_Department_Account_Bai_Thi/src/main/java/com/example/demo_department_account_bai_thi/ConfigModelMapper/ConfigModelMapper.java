package com.example.demo_department_account_bai_thi.ConfigModelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// đánh dấu class dưới 1 component đặc biệt
// khi spring run lên , sẽ quét để tạo các bean để sử dụng
@Configuration
public class ConfigModelMapper {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
