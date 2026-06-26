package com.techie.microservices.order.service;

import com.techie.microservices.order.client.InventoryClient;
import com.techie.microservices.order.dto.OrderEvent;
import com.techie.microservices.order.dto.OrderRequest;
import com.techie.microservices.order.model.Address;
import com.techie.microservices.order.model.Customer;
import com.techie.microservices.order.model.Order;
import com.techie.microservices.order.repository.OrderRepository;
import com.techie.microservices.order.service.kafka.OrderProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final EmailService emailService;
    private final OrderProducer orderProducer;

    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient, EmailService emailService, OrderProducer orderProducer) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
        this.emailService = emailService;
        this.orderProducer = orderProducer;
    }

    @Transactional
    public void placeOrder(OrderRequest orderRequest) {

        var isProductInStock = inventoryClient.isInStock(orderRequest.getSkuCode(), orderRequest.getQuantity());

        if (isProductInStock) {
            // Map OrderRequest to Order object
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.getPrice());
            order.setSkuCode(orderRequest.getSkuCode());
            order.setQuantity(orderRequest.getQuantity());
            order.setCustomer(new Customer());
            order.setAddress(new Address());



            // Save order to OrderRepository
            log.info("Saving Order Details in Repo");
            orderRepository.save(order);

            // Publish Event To Kafka
            OrderEvent orderEvent = new OrderEvent(
                    order.getId(),
                    order.getOrderNumber(),
                    order.getSkuCode(),
                    order.getPrice(),
                    order.getQuantity(),
                    order.getCustomer(),
                    order.getAddress()
            );


            emailService.sendOrderConfirmationEmail(orderRequest);
            orderProducer.sendOrderEvent(orderEvent);

        } else {
            throw new RuntimeException("Product with skuCode " + orderRequest.getSkuCode() + " is not in stock");
        }
    }
}
