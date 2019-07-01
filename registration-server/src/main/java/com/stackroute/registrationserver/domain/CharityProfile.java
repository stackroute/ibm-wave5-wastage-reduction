package com.stackroute.registrationserver.domain;

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
public class CharityProfile {

        @Id
        private String charityId;
        private String username;
        private String charityName;
        private String certificateNo;
        private String phoneNo;
        private String address;
    }


