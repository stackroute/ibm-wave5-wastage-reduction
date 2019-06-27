package com.stackroute.routingService.service.rabbitMQservice;


import com.stackroute.routingService.domain.Charity;
import com.stackroute.routingService.domain.DeliveryBoy;
import com.stackroute.routingService.domain.Restaurant;
import com.stackroute.routingService.repository.CharityRepository;
import com.stackroute.routingService.repository.DeliveryBoyRepository;
import com.stackroute.routingService.repository.RestaurantRepository;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RabbitListener(queues = "${saveRestaurant.rabbitmq.queue}")
public class RestaurantListener {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CharityRepository charityRepository;

    @Autowired
    private DeliveryBoyRepository deliveryBoyRepository;

    @RabbitHandler @Transactional
    public void recievedAndSaved(String restaurant) {
//        charityRepository.saveCharity("1","HappyHome","60","12.934127,77.611946","0",1.0);
        String[] restaurantDetails = restaurant.split("&");
        System.out.println(restaurantRepository.saveRestaurant(restaurantDetails[0], restaurantDetails[1], restaurantDetails[2], "0", "no"));
        String[] restaurantLocation = restaurantDetails[2].split(",");
        double restaurantLat = Double.parseDouble(restaurantLocation[0]);
        double restaurantLon = Double.parseDouble(restaurantLocation[1]);
        List<Charity> charityList = charityRepository.fetchCharities();
        for (int i = 0; i < charityList.size(); i++) {
            Charity charity = charityList.get(i);
            String[] charityLocation = charity.getLocation().split(",");
            double charityLat = Double.parseDouble(charityLocation[0]);
            double charityLon = Double.parseDouble(charityLocation[1]);
            double distance = getDistanceFromLatLonInKm(restaurantLat,restaurantLon,charityLat,charityLon);
            charityRepository.createRestaurantCharityRelation(restaurantDetails[0],charity.getCharityId(),distance,"no");
        }
        List<DeliveryBoy> deliveryBoyList = deliveryBoyRepository.fetchDeliveryBoys();
        for (int j = 0; j < deliveryBoyList.size(); j++){
            DeliveryBoy deliveryBoy = deliveryBoyList.get(j);
            String[] deliveryBoyLocation = deliveryBoy.getLocation().split(",");
            double deliveryBoyLat = Double.parseDouble(deliveryBoyLocation[0]);
            double deliveryBoyLon = Double.parseDouble(deliveryBoyLocation[1]);
            double distance = getDistanceFromLatLonInKm(restaurantLat,restaurantLon,deliveryBoyLat,deliveryBoyLon);
            deliveryBoyRepository.createRestaurantDeliveryBoyRelation(restaurantDetails[0],deliveryBoy.getDeliveryBoyId(),distance);

        }
    }

    double getDistanceFromLatLonInKm(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371; // Radius of the earth in km
        double dLat = Math.toRadians(lat2 - lat1);  // conversion to radians
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c; // Distance in km
    }
}
