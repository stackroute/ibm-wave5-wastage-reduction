package com.stackroute.authenticationserver.service;

import com.stackroute.authenticationserver.model.Users;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${rabbitmq.queue}")
public class RabbitService {


    @RabbitHandler
    public void recievedMessage(Users employee) {
        System.out.println("Recieved Message From RabbitMQ: " + employee);
    }

}