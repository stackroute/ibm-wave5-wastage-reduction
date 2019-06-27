package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.Charity;
import com.stackroute.registrationserver.domain.CharityProfile;

import java.util.List;

public interface CharityService {

    public CharityProfile saveCharity(Charity charity) throws Exception;
    public List<CharityProfile> displayCharity();

}