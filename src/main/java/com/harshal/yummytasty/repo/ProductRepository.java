package com.harshal.yummytasty.repo;

import com.harshal.yummytasty.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

    Products findProductsByProductName(String productName);


    @Query("SELECT p FROM Products p WHERE p.price BETWEEN :low AND :high ORDER BY p.price ASC")
    List<Products> fetchTopProductByPrice(@Param("low") String low, @Param("high") String high);
}