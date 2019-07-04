package com.stackroute.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Charity {

    private String username;
    private String password;
    private String charityName;
    private String email;
    private String certificateNo;
    private String phoneNo;
    private String address;
    private String location;
    private long foodRequirement;
    private String certificateName;
}
