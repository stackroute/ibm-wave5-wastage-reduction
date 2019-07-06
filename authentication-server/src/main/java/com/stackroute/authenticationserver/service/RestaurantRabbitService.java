package com.stackroute.authenticationserver.service;

import com.stackroute.authenticationserver.model.User;
import com.stackroute.rabbitmq.model.Charity;
import com.stackroute.rabbitmq.model.Restaurant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${restaurant.queue}")
@RabbitListener(queues = "${charity.queue}")
public class RestaurantRabbitService {


    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RabbitHandler
    public void recievedRestaurantMessage(Restaurant restaurant) throws Exception{
        System.out.println("Recieved Restaurant Message From RabbitMQ: " + restaurant);
        User user = new User(restaurant.getUsername(),restaurant.getPassword(), restaurant.getRole());
        userDetailsService.save(user);

    }

    @RabbitHandler
    public void recievedCharityMessage(Charity charity) throws Exception{
        System.out.println("Recieved Message From RabbitMQ: " + charity);
        User user = new User(charity.getUsername(),charity.getPassword(), charity.getRole());
        userDetailsService.save(user);

    }
}