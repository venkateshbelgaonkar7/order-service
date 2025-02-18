package com.techie.microservices.order.dto;

import com.techie.microservices.order.model.Address;
import com.techie.microservices.order.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Data
@Setter
@Getter
@AllArgsConstructor
public class OrderRequest {
    private Long id;
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
    private Customer customer;
    private Address address;
}
