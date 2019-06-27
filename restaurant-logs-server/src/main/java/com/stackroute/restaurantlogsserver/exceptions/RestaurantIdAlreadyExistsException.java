package com.stackroute.restaurantlogsserver.exceptions;

public class RestaurantIdAlreadyExistsException extends Exception {
    private String message;
    public RestaurantIdAlreadyExistsException(){
    }
    public RestaurantIdAlreadyExistsException(String message)
    {
        super(message);
        this.message=message;
    }
}
