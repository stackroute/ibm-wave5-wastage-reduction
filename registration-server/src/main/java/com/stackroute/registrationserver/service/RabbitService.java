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

    @Value("${restaurant.exchange}")
    private String restaurantExchange;

    @Value("${restaurant.routingkey}")
    private String restaurantRoutingkey;

    @Value("${charity.exchange}")
    private String charityExchange;

    @Value("${charity.routingkey}")
    private String charityRoutingkey;

//    @Value("${deliveryBoy.exchange}")
//    private String deliveryBoyExchange;
//
//    @Value("${deliveryBoy.routingkey}")
//    private String deliveryBoyRoutingkey;

    public void sendToRestaurantRabbitMq(Restaurants restaurants) {

        Restaurant restaurant = new Restaurant(restaurants.getUsername(),restaurants.getPassword(),restaurants.getEmail(),restaurants.getRole(),restaurants.getRestaurantName(),restaurants.getMobile(),restaurants.getAddress(),restaurants.getLocation(),restaurants.getCertificateNo(),restaurants.getCertificateName());

        rabbitTemplate.convertAndSend(restaurantExchange, restaurantRoutingkey,restaurant);

        System.out.println("Send msg = " + restaurant);

    }

    public void sendToCharityRabbitMq(Charities charities) {

        Charity charity = new Charity(charities.getUsername(),charities.getPassword(),charities.getEmail(), charities.getRole(),charities.getCharityName(),charities.getMobile(),charities.getAddress(),charities.getLocation(),charities.getFoodRequirement(),charities.getCertificateNo(),charities.getCertificateName());

        rabbitTemplate.convertAndSend(charityExchange, charityRoutingkey,charity);

        System.out.println("Send msg = " + charity);

    }

//    public void sendToDeliveryBoyRabbitMq(DeliveryBoys deliveryBoys) {
//
//        DeliveryBoy deliveryBoy = new DeliveryBoy(deliveryBoys.getUsername(),deliveryBoys.getPassword(),deliveryBoys.getEmail(),deliveryBoys.getRole(),deliveryBoys.getDeliveryBoyName(),deliveryBoys.getMobile(),deliveryBoys.getAddress(),deliveryBoys.getLicenseNo(),deliveryBoys.getLicenseName());
//        rabbitTemplate.convertAndSend(deliveryBoyExchange, deliveryBoyRoutingkey,deliveryBoy);
//
//        System.out.println("Sent CharityMQ = " + deliveryBoy);
//
//    }

}