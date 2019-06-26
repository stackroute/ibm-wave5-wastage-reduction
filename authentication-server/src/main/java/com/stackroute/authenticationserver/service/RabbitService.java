package com.stackroute.authenticationserver.service;

import com.stackroute.authenticationserver.model.User;
import com.stackroute.rabbitmq.model.Restaurant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${rabbitmq.queue}")
public class RabbitService {


    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RabbitHandler
    public void recievedMessage(Restaurant restaurant) {
        System.out.println("Recieved Message From RabbitMQ: " + restaurant);
        User user = new User(restaurant.getRestaurantId(),restaurant.getUsername(),restaurant.getPassword());
        userDetailsService.save(user);

    }

}