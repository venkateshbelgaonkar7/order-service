package com.techie.microservices.order.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddressRequest {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private Long zipCode;
}
