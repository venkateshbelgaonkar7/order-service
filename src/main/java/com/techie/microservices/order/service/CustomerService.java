package com.techie.microservices.order.service;

import com.techie.microservices.order.entity.Customer;
import com.techie.microservices.order.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public ResponseEntity<Customer> saveCustomer(Customer Customer) {
        return customerRepository.save(customer);
    }
}
