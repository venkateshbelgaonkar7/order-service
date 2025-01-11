package com.techie.microservices.order.dto;

import lombok.Data;

import java.math.BigDecimal;

public record OrderRequest(Long id, String orderNumber,
                           String skuCode, BigDecimal price,
                           Integer quantity) {

}
