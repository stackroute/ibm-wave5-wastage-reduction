package com.stackroute.charityserver.service;

import com.stackroute.charityserver.domain.CharityLogs;
import com.stackroute.charityserver.repository.CharityLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharityLogsServiceImpl implements CharityLogsService {

    @Autowired
    CharityLogsRepository charityLogsRepository;
    public CharityLogsServiceImpl(){}

    public CharityLogsServiceImpl(CharityLogsRepository charityLogsRepository){this.charityLogsRepository=charityLogsRepository;}

    @Override
    public CharityLogs addCharityProfile(CharityLogs charityProfile) {

//        if(charityProfileRepository.exists(charityProfile.getPhoneNo())){
//            return charityProfileRepository.save(charityProfile);}
        return charityLogsRepository.save(charityProfile);
    }

    @Override
    public List<CharityLogs> displayAll() {
        return charityLogsRepository.findAll();
    }
}
