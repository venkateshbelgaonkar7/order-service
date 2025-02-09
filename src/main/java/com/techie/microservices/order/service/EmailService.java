package com.techie.microservices.order.service;

import com.techie.microservices.order.dto.OrderRequest;
import com.techie.microservices.order.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendOrderConfirmationEmail(OrderRequest orderRequest) {
        Context context = new Context();
        context.setVariable("order", orderRequest);

        String body = templateEngine.process("email-confirmation", context);

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(orderRequest.customer().getEmail());
            messageHelper.setSubject(":: Order Confirmation -- "+orderRequest.orderNumber());
            messageHelper.setText(body, true);
        };
        mailSender.send(messagePreparator);
    }

}
