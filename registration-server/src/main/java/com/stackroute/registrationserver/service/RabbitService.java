package com.stackroute.registrationserver.service;

import com.stackroute.rabbitmq.model.Charity;
import com.stackroute.rabbitmq.model.DeliveryBoy;
import com.stackroute.rabbitmq.model.Restaurant;
import com.stackroute.registrationserver.domain.Charities;
import com.stackroute.registrationserver.domain.DeliveryBoys;
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

    public void sendToRestaurantRabbitMq(Restaurants restaurants) {

        Restaurant restaurant = new Restaurant(restaurants.getUsername(),restaurants.getPassword(),restaurants.getEmail(),restaurants.getRestaurantName(),restaurants.getMobile(),restaurants.getCertificateNo(),restaurants.getPhoneNo(),restaurants.getAddress(),restaurants.getLocation(),restaurants.getCertificateName());

        rabbitTemplate.convertAndSend(exchange, routingkey,restaurant);

        System.out.println("Send msg = " + restaurant);

    }

    public void sendToCharityRabbitMq(Charities charities) {

        Charity charity = new Charity(charities.getUsername(),charities.getPassword(),charities.getCharityName(),charities.getEmail(),charities.getCertificateNo(),charities.getPhoneNo(),charities.getAddress(),charities.getLocation(),charities.getFoodRequirement(),charities.getCertificateName());

        rabbitTemplate.convertAndSend(exchange, routingkey,charity);

        System.out.println("Send msg = " + charity);

    }

    public void sendToDeliveryBoyRabbitMq(DeliveryBoys deliveryBoys) {

        DeliveryBoy deliveryBoy = new DeliveryBoy(deliveryBoys.getDeliveryBoyName(),deliveryBoys.getEmail(),deliveryBoys.getUsername(),deliveryBoys.getPassword(),deliveryBoys.getMobile(),deliveryBoys.getAddress(),deliveryBoys.getLicenseNo(),deliveryBoys.getLicenseName());
        rabbitTemplate.convertAndSend(exchange, routingkey,deliveryBoy);

        System.out.println("Sent CharityMQ = " + deliveryBoy);

    }

}