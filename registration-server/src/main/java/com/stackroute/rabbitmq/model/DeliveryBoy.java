package com.stackroute.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryBoy {

    private String deliveryBoyName;
    private String email;
    private String username;
    private String password;
    private Long mobile;
    private String address;
    private String licenseNo;
    private String licenseName;
}
