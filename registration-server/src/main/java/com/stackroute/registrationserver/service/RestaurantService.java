package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.Restaurants;

public interface RestaurantService {

    public Restaurants saveRestaurant(Restaurants restaurant) throws Exception;

//    public void sendToRabbitMq(Restaurant restaurant);

}