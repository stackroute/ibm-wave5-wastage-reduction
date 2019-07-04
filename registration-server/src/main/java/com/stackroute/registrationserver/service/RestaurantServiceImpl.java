package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.Restaurants;
import com.stackroute.registrationserver.domain.RestaurantProfile;
import com.stackroute.registrationserver.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){

        this.restaurantRepository = restaurantRepository;

    }

    @Override
    public RestaurantProfile saveRestaurant(Restaurants restaurant) throws Exception {

        System.out.println(restaurant);

        RestaurantProfile restaurantProfile = new RestaurantProfile(restaurant.getUsername(),restaurant.getEmail(),restaurant.getRestaurantName(),restaurant.getMobile(),restaurant.getAddress(),restaurant.getLocation(),restaurant.getCertificateNo(),restaurant.getCertificateName());

        RestaurantProfile savedRestaurantDetails = restaurantRepository.save(restaurantProfile);
        if (savedRestaurantDetails == null)
            throw new Exception("User Already Exists");
        return savedRestaurantDetails;
    }

    @Override
    public List<RestaurantProfile> displayRestaurants() throws Exception {
        return restaurantRepository.findAll();
    }


}
