package com.harshal.yummytasty.mapper;

import com.harshal.yummytasty.dto.ProductsRequest;
import com.harshal.yummytasty.entity.Products;
import org.springframework.stereotype.Service;

@Service
public class ProductsMapper {
    public Products toEntity(ProductsRequest request) {
        return Products.builder()
                .productName(request.product_name())
                .price(request.price())
                .build();
    }
}