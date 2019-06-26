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
public class RestaurantProfile {

    @Id
            String restaurantId;

    String username;

    String password;

    String restaurantName;

    String certificateNo;

    Long phoneNo;

    String address;

    String email;

}
