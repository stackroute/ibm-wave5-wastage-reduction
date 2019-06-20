package com.stackroute.registration.registrationserver.service;

import com.stackroute.registration.registrationserver.domain.Charity;

public interface CharityService {

    public Charity saveCharity(Charity charity) throws Exception;

}