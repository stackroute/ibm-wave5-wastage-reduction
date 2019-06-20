package com.stackroute.registration.registrationserver.service;

import com.stackroute.registration.registrationserver.domain.Restaurant;

public interface RestaurantService {

    public Restaurant saveRestaurant(Restaurant restaurant) throws Exception;

    public void sendToRabbitMq(Restaurant restaurant);

}