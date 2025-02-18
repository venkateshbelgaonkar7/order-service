package com.techie.microservices.order.service.kafka;

import com.techie.microservices.order.dto.OrderEvent;
import org.springframework.kafka.annotation.EnableKafkaRetryTopic;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderEvent(OrderEvent orderEvent) {
        kafkaTemplate.send(":: order-event", orderEvent);
    }
}
