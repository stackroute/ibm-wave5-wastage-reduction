package com.stackroute.registrationserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurants {

    String restaurantId;

    String username;

    String password;

    String restaurantName;

    String certificateNo;

    String phoneNo;

    String address;
}
