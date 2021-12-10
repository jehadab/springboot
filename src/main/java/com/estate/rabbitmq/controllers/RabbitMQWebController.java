package com.estate.rabbitmq.controllers;

import com.estate.rabbitmq.Email;
import com.estate.rabbitmq.services.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class RabbitMQWebController {
    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/send")
    public String producer(@RequestParam("content") String content, @RequestParam("address") String address, @RequestParam("date") Date date) {

        Email email=new Email();
        email.setAddress(address);
        email.setContent(content);
        email.setDate(date);
        rabbitMQSender.send(email);

        return "Message sent to the RabbitMQ Successfully";
    }
}
