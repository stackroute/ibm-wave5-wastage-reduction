package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.Charity;
import com.stackroute.registrationserver.domain.CharityProfile;
import com.stackroute.registrationserver.repository.CharityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharityServiceImpl implements CharityService {

    CharityRepository charityRepository;

    @Autowired
    public CharityServiceImpl(CharityRepository charityRepository){

        this.charityRepository = charityRepository;

    }

    @Override
    public CharityProfile saveCharity(Charity charity) throws Exception {
        CharityProfile charityProfile = new CharityProfile(charity.getCharityId(),charity.getUsername(),charity.getCharityName(),charity.getCertificateNo(),charity.getPhoneNo(),charity.getAddress());
        CharityProfile savedCharity = charityRepository.save(charityProfile);
        if (savedCharity == null)
            throw new Exception("User Already Exists");
        return savedCharity;
    }

    @Override
    public List<CharityProfile> displayCharity() {
        return charityRepository.findAll();
    }
}
