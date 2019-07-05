package com.stackroute.authenticationserver.service;

import com.stackroute.authenticationserver.model.User;
import com.stackroute.rabbitmq.model.Restaurant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${restaurant.queue}")
public class RestaurantRabbitService {


    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RabbitHandler
    public void recievedRestaurantMessage(Restaurant restaurant) throws Exception{
        User user = new User(restaurant.getUsername(),restaurant.getPassword());
        userDetailsService.save(user);

    }

}