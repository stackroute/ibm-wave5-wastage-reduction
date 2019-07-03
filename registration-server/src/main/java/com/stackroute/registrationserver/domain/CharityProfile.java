package com.stackroute.registrationserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;


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


