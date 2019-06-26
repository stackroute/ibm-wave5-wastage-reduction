package com.stackroute.registrationserver.controller;

import com.stackroute.registrationserver.domain.Charity;
import com.stackroute.registrationserver.domain.Restaurants;
import com.stackroute.registrationserver.service.CharityService;
import com.stackroute.registrationserver.service.RabbitService;
import com.stackroute.registrationserver.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("restaurant")
    public ResponseEntity<?> saveRestaurant(@RequestBody Restaurants restaurant) throws Exception {
        ResponseEntity responseEntity;
        try {
            Restaurants returnRestaurant = restaurantService.saveRestaurant(restaurant);
            responseEntity = new ResponseEntity<Restaurants>(restaurant, HttpStatus.CREATED);

            rabbitService.sendToRabbitMq(restaurant);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
//            throw trackAlreadyExistsException;
        }

        return responseEntity;
    }


    @PostMapping("charity")
    public ResponseEntity<?> saveCharity(@RequestBody Charity charity) throws Exception {
        ResponseEntity responseEntity;
        try {
            Charity returnCharity = charityService.saveCharity(charity);
            responseEntity = new ResponseEntity<Charity>(charity, HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
//            throw trackAlreadyExistsException;
        }

        return responseEntity;
    }
}
