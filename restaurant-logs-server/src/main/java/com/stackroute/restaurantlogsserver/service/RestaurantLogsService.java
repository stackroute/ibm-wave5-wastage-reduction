package com.stackroute.restaurantlogsserver.service;


import com.stackroute.restaurantlogsserver.domain.RestaurantLogs;
import com.stackroute.restaurantlogsserver.exceptions.RestaurantIdAlreadyExistsException;

import java.util.List;

public interface RestaurantLogsService {
    public RestaurantLogs saveRestaurantLog(RestaurantLogs restaurantLog) throws RestaurantIdAlreadyExistsException;
    public List<RestaurantLogs> getAllRestaurantLog() throws Exception;
}
