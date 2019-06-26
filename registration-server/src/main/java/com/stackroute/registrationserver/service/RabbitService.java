package com.stackroute.registrationserver.service;

import com.stackroute.rabbitmq.model.Restaurant;
import com.stackroute.registrationserver.domain.Restaurants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${rabbitmq.queue}")
public class RabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    public void sendToRabbitMq(Restaurants restaurants) {

        Restaurant restaurant = new Restaurant(restaurants.getRestaurantId(),restaurants.getUsername(), restaurants.getPassword(), restaurants.getRestaurantName(), restaurants.getCertificateNo(), restaurants.getPhoneNo(), restaurants.getAddress());

        rabbitTemplate.convertAndSend(exchange, routingkey,restaurant);

        System.out.println("Send msg = " + restaurant);

    }

}