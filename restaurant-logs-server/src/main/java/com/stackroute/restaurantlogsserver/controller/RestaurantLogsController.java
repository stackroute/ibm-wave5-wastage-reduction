package com.stackroute.restaurantlogsserver.controller;


import com.stackroute.restaurantlogsserver.domain.RestaurantLogs;
import com.stackroute.restaurantlogsserver.exceptions.RestaurantIdAlreadyExistsException;
import com.stackroute.restaurantlogsserver.service.RestaurantLogsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class RestaurantLogsController {
    RestaurantLogsService restaurantLogService;
    public RestaurantLogsController(RestaurantLogsService restaurantLogService)
    {
        this.restaurantLogService = restaurantLogService;
    }
    @PostMapping("restaurant")
    public ResponseEntity<?> saveRestaurantLog(@RequestBody RestaurantLogs restaurantLog) {
        ResponseEntity responseEntity;
        try
        {
            restaurantLogService.saveRestaurantLog(restaurantLog);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }
        catch (RestaurantIdAlreadyExistsException ex)
        {

            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);

        }
        return responseEntity;
    }
    @GetMapping("restaurant")
    public ResponseEntity<?> getAllRestaurantLogs() throws Exception {
        return new ResponseEntity<List<RestaurantLogs>>(restaurantLogService.getAllRestaurantLog(),HttpStatus.OK);
    }
}
