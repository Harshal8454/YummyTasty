package com.harshal.yummytasty.service;


import com.harshal.yummytasty.dto.CustomerRequest;
import com.harshal.yummytasty.entity.Customer;
import com.harshal.yummytasty.mapper.CustomerMapper;
import com.harshal.yummytasty.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.harshal.yummytasty.helper.EncryptionService;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo repo;

    private final CustomerMapper mapper;

    private final EncryptionService encryptionService;

    public Customer createCustomer(CustomerRequest request) {
        System.out.println("==================== create service");

        Customer customer = mapper.toEntity(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        repo.save(customer);
        return customer;
    }
}