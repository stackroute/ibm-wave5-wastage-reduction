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
@RabbitListener(queues = "${saveDeliveryBoy.rabbitmq.queue}")
public class DeliveryBoyListener {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CharityRepository charityRepository;

    @Autowired
    private DeliveryBoyRepository deliveryBoyRepository;

    @RabbitHandler @Transactional
    public void recievedAndSaved(String deliveryBoy) {
        String[] deliveryBoyDetails = deliveryBoy.split("&");
        double deliveryBoyLat = 12.971599;
        double deliveryBoyLon = 77.594566;
        System.out.println(deliveryBoyRepository.saveDeliveryBoy(deliveryBoyDetails[0], deliveryBoyDetails[1], deliveryBoyDetails[2], deliveryBoyLat+ "," + deliveryBoyLon));
//        String[] deliveryBoyLocation = deliveryBoyDetails[3].split(",");
//        double deliveryBoyLat = Double.parseDouble(deliveryBoyLocation[0]);
        List<Restaurant> restaurantList = restaurantRepository.fetchRestaurants();
        for (int i = 0; i < restaurantList.size(); i++) {
            Restaurant restaurant = restaurantList.get(i);
            String[] restaurantLocation = restaurant.getLocation().split(",");
            double restaurantLat = Double.parseDouble(restaurantLocation[0]);
            double restaurantLon = Double.parseDouble(restaurantLocation[1]);
            double distance = getDistanceFromLatLonInKm(deliveryBoyLat,deliveryBoyLon,restaurantLat,restaurantLon);
            deliveryBoyRepository.createRestaurantDeliveryBoyRelation(restaurant.getRestaurantId(),deliveryBoyDetails[0],distance);
        }
        List<Charity> charityList = charityRepository.fetchCharities();
        for (int j = 0; j < charityList.size(); j++){
            Charity charity = charityList.get(j);
            String[] charityLocation = charity.getLocation().split(",");
            double charityLat = Double.parseDouble(charityLocation[0]);
            double charityLon = Double.parseDouble(charityLocation[1]);
            double distance = getDistanceFromLatLonInKm(deliveryBoyLat,deliveryBoyLon,charityLat,charityLon);
            deliveryBoyRepository.createDeliveryBoyCharityRelation(deliveryBoyDetails[0],charity.getCharityId(),distance);

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
