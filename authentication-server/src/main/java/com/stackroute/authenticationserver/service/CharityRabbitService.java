//package com.stackroute.authenticationserver.service;
//
//import com.stackroute.authenticationserver.model.User;
//import com.stackroute.rabbitmq.model.Charity;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//@Component
//@RabbitListener(queues = "${charity.queue}")
//public class CharityRabbitService {
//
//    @Autowired
//    private JwtUserDetailsService userDetailsService;
//
//    @RabbitHandler
//    public void recievedCharityMessage(Charity charity) throws Exception{
//        System.out.println("Recieved Message From RabbitMQ: " + charity);
//        User user = new User(charity.getUsername(),charity.getPassword());
//        userDetailsService.save(user);
//
//    }
//}
