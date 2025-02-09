package com.techie.microservices.order.model;

import com.techie.microservices.order.entity.Address;
import com.techie.microservices.order.entity.Customer;
import com.techie.microservices.order.entity.OrderItem;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@Data
public class OrderModel {

    private Long id;
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
    private Customer customer;
    private Address address;
    private OrderItem orderItem;
}
