package com.stackroute.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    private String username;
    private String password;
    private String email;
    private String restaurantName;
    private long mobile;
    private String certificateNo;
    private String phoneNo;
    private String address;
    private String location;
    private String certificateName;
}
