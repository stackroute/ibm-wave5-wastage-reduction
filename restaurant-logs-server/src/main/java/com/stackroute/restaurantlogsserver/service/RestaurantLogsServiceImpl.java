package com.stackroute.restaurantlogsserver.service;

import com.stackroute.restaurantlogsserver.domain.RestaurantLogs;
import com.stackroute.restaurantlogsserver.exceptions.RestaurantIdAlreadyExistsException;
import com.stackroute.restaurantlogsserver.repository.RestaurantLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantLogsServiceImpl implements RestaurantLogsService {
    RestaurantLogsRepository restaurantLogRepository;

    @Autowired
    public RestaurantLogsServiceImpl(RestaurantLogsRepository restaurantLogRepository)
    {
        this.restaurantLogRepository=restaurantLogRepository;
    }
    @Override
    public RestaurantLogs saveRestaurantLog(RestaurantLogs restaurantLog) throws RestaurantIdAlreadyExistsException{
        RestaurantLogs savedrestaurantLog =restaurantLogRepository.save(restaurantLog);
        return savedrestaurantLog;
    }

    @Override
    public List<RestaurantLogs> getAllRestaurantLog() throws Exception {
        List<RestaurantLogs> log = restaurantLogRepository.findAll();
        return log;
    }
}