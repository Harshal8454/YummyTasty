package com.harshal.yummytasty.service;
import java.util.Optional;

import com.harshal.yummytasty.dto.LoginRequest;
import com.harshal.yummytasty.entity.Customer;
import com.harshal.yummytasty.mapper.LoginMapper;
import com.harshal.yummytasty.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.harshal.yummytasty.helper.EncryptionService;
import com.harshal.yummytasty.helper.JWTHelper;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final CustomerRepo repo;
    private final LoginMapper mapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;

    public String loginUser(LoginRequest request) {
        Customer customer = mapper.toEntity(request);
        Optional<Customer> existingCustomer = repo.findByEmail(customer.getEmail());

        if (existingCustomer.isPresent()) {
            if(!encryptionService.validates(request.password(), existingCustomer.get().getPassword())) {
                return "Wrong Password or Email";
            }
            else {
                return jwtHelper.generateToken(request.email());
            }
        } else {
            return "User not found";
        }
    }
}