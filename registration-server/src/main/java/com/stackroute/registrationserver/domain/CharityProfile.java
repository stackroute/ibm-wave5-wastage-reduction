package com.stackroute.registrationserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
//import org.hibernate.annotations.Entity;
//import org.springframework.data.annotation.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharityProfile {

        @Id
        private String username;
        private String charityName;
        private String email;
        private Long mobile;
        private String certificateNo;
        private String address;
        private String location;
        private Long foodRequirement;
        private String certificateName;

}


