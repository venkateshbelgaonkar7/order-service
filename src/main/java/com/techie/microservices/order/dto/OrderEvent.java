package com.techie.microservices.order.dto;

import com.techie.microservices.order.model.Address;
import com.techie.microservices.order.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderEvent {
    private Long id;
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
    private Customer customer;
    private Address address;

}
