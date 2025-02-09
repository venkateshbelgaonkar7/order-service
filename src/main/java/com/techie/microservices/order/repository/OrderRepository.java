package com.techie.microservices.order.repository;

import com.techie.microservices.order.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {

    Optional<OrderModel> findByOrderNumber(String orderNumber);
}
