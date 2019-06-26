package com.stackroute.charityserver.service;

import com.stackroute.charityserver.domain.CharityLogs;

import java.util.List;

public interface CharityLogsService {
    public CharityLogs addCharityProfile(CharityLogs charityProfile);

    public List<CharityLogs> displayAll();


}
