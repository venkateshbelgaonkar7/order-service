package com.techie.microservices.order.service;

import com.techie.microservices.order.dto.OrderRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
public class EmailService {

    private JavaMailSender mailSender;

    private SpringTemplateEngine templateEngine;

    public void sendOrderConfirmationEmail(OrderRequest orderRequest) {
        Context context = new Context();
        context.setVariable("order", orderRequest);

        String body = templateEngine.process("Email-Confirmation", context);

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(orderRequest.getCustomer().getEmail());
            messageHelper.setSubject(":: Order Confirmation -- "+orderRequest.getOrderNumber());
            messageHelper.setText(body, true);
        };
        mailSender.send(messagePreparator);
    }

}
