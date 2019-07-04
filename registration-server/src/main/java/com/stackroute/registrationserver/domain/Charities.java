package com.stackroute.registrationserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Charities {

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
