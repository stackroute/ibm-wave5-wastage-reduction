package com.stackroute.registrationserver.repository;

import com.stackroute.registrationserver.domain.RestaurantProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantProfile, String> {
}
