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

    private String username;
    private String password;
    private String email;
    private String restaurantName;
    private long mobile;
    private String address;
    private String location;
    private String certificateNo;
    private String certificateName;

}
