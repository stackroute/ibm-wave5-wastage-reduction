package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.Charity;
import com.stackroute.registrationserver.domain.CharityProfile;

import java.util.List;

public interface CharityService {

    CharityProfile saveCharity(Charity charity) throws Exception;
    List<CharityProfile> displayCharity();

}