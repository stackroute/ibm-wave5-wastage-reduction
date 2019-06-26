package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.Restaurants;
import com.stackroute.registrationserver.domain.RestaurantDetails;
import com.stackroute.registrationserver.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){

        this.restaurantRepository = restaurantRepository;

    }

    @Override
    public Restaurants saveRestaurant(Restaurants restaurant) throws Exception {

        RestaurantDetails restaurantDetails = new RestaurantDetails(restaurant.getRestaurantId(),restaurant.getUsername(),restaurant.getRestaurantName(),restaurant.getCertificateNo(),restaurant.getPhoneNo(),restaurant.getAddress());

        RestaurantDetails savedRestaurantDetails = restaurantRepository.save(restaurantDetails);
        if (savedRestaurantDetails == null)
            throw new Exception("User Already Exists");
        return null;
    }


}
