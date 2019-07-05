package com.stackroute.registrationserver.controller;

import com.stackroute.rabbitmq.model.Restaurant;
import com.stackroute.registrationserver.domain.Charities;
import com.stackroute.registrationserver.domain.CharityProfile;
import com.stackroute.registrationserver.domain.RestaurantProfile;
import com.stackroute.registrationserver.domain.Restaurants;
import com.stackroute.registrationserver.service.CharityService;
import com.stackroute.registrationserver.service.RabbitService;
import com.stackroute.registrationserver.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin(origins = "*")
public class RegistrationController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CharityService charityService;

    @Autowired
    private RabbitService rabbitService;

    @PostMapping("restaurant-profile")
    public ResponseEntity<RestaurantProfile> saveRestaurant(@RequestBody Restaurants restaurant) throws Exception {
        ResponseEntity responseEntity;

        try {

            RestaurantProfile returnRestaurant = restaurantService.saveRestaurant(restaurant);
            responseEntity = new ResponseEntity<RestaurantProfile>(returnRestaurant, HttpStatus.CREATED);

            rabbitService.sendToRestaurantRabbitMq(restaurant);

        } catch (Exception e) {

            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);

        }

        return responseEntity;
    }
    @GetMapping("restaurant-profile")
    public ResponseEntity<List<Restaurant>> displayRestaurant()
    {
        ResponseEntity responseEntity;

        try{

            responseEntity=new ResponseEntity(restaurantService.displayRestaurants(),HttpStatus.CREATED);

        }
        catch (Exception e){

            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);

        }
        return responseEntity;
    }


    @PostMapping("charity-profile")
    public ResponseEntity<CharityProfile> saveCharity(@RequestBody Charities charity) throws Exception {
        ResponseEntity responseEntity;
        try {

            CharityProfile returnCharity = charityService.saveCharity(charity);
            responseEntity = new ResponseEntity<CharityProfile>(returnCharity, HttpStatus.CREATED);

            rabbitService.sendToCharityRabbitMq(charity);

        } catch (Exception e) {

            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);

        }

        return responseEntity;
    }
    @GetMapping("charity-profile")
    public ResponseEntity<List<CharityProfile>> displayCharity()
    {
        ResponseEntity responseEntity;

        try{

            responseEntity=new ResponseEntity(charityService.displayCharity(),HttpStatus.CREATED);

        }
        catch (Exception e){

            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);

        }
        return responseEntity;
    }
}
