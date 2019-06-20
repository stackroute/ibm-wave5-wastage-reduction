package com.stackroute.registration.registrationserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDetails {

    @Id
    String restaurantId;

    String username;

    String restaurantName;

    String certificateNo;

    int phoneNo;

    String address;

}
