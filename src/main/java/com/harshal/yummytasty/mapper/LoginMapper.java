package com.harshal.yummytasty.mapper;

import com.harshal.yummytasty.dto.LoginRequest;
import com.harshal.yummytasty.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class LoginMapper {
    public Customer toEntity(LoginRequest request) {
        return Customer.builder()
                .email(request.email())
                .password(request.password())
                .build();
    }
}