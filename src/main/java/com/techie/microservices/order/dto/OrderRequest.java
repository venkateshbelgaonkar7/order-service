package com.techie.microservices.order.dto;

import com.techie.microservices.order.entity.Address;
import com.techie.microservices.order.entity.Customer;
import lombok.Data;

import java.math.BigDecimal;

public record OrderRequest(Long id, String orderNumber,
                           String skuCode, BigDecimal price,
                           Integer quantity, Customer customer, Address address) {

}
