package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.RestaurantProfile;
import com.stackroute.registrationserver.domain.Restaurants;

import java.util.List;

public interface RestaurantService {

    public RestaurantProfile saveRestaurant(Restaurants restaurant) throws Exception;
    public List<RestaurantProfile> displayRestaurants() throws Exception;
    //public void sendToRabbitMq(Restaurant restaurant);
//    public void sendToRabbitMq(Restaurant restaurant);

}