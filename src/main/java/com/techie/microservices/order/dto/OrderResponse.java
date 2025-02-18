package com.techie.microservices.order.dto;

import com.techie.microservices.order.model.Address;
import com.techie.microservices.order.model.Customer;
import com.techie.microservices.order.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;


@Setter
@Getter
@Data
public class OrderResponse{
        private Long id;
        private String orderNumber;
        private String skuCode;
        private BigDecimal price;
        private Integer quantity;
        private Customer customer;
        private Address  address;
        private List<OrderItem> orderItem;
}


