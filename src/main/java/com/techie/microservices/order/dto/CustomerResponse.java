package com.techie.microservices.order.dto;

import com.techie.microservices.order.model.Address;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Data
public class CustomerResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;
    private List<Address> addresses;
}
