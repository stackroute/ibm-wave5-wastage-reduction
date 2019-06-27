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
    public CharityLogs saveCharityLogs(CharityLogs charityLogs) throws Exception{

        if(charityLogsRepository.existsById(charityLogs.getId())) {
            throw new Exception("Charity already exists");
        }
        else
            return charityLogsRepository.save(charityLogs);
    }

    @Override
    public List<CharityLogs> displayCharityLogs() {
        return charityLogsRepository.findAll();
    }
}
