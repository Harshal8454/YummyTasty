package com.harshal.yummytasty.mapper;

import com.harshal.yummytasty.dto.CustomerRequest;
import com.harshal.yummytasty.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .first_name(request.first_name())
                .last_name(request.first_name())

                .email(request.email())
                .password(request.password())
                .build();
    }
}