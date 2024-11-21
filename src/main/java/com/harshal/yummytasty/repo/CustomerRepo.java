package com.harshal.yummytasty.repo;
import java.util.Optional;

import com.harshal.yummytasty.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}