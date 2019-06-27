package com.stackroute.registrationserver.repository;

import com.stackroute.registrationserver.domain.Charity;
import com.stackroute.registrationserver.domain.CharityProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharityRepository extends JpaRepository<CharityProfile, String> {
}
