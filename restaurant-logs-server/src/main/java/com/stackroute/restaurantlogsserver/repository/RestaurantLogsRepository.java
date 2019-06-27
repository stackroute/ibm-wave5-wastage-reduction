package com.stackroute.restaurantlogsserver.repository;
import com.stackroute.restaurantlogsserver.domain.RestaurantLogs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantLogsRepository extends MongoRepository<RestaurantLogs,Integer>{
}
