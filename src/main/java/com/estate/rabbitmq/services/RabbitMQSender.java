package com.estate.rabbitmq.services;

import com.estate.rabbitmq.Email;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${estate.rabbitmq.exchange}")
    private String exchange;

    @Value("${estate.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Email company) {
        rabbitTemplate.convertAndSend(exchange, routingkey, company);
        System.out.println("Send msg = " + company);

    }
}
