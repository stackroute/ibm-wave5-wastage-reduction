package com.stackroute.charityserver.service;

import com.stackroute.charityserver.domain.CharityLogs;

import java.util.List;

public interface CharityLogsService {
    public CharityLogs saveCharityLogs(CharityLogs charityLogs) throws Exception;

    public List<CharityLogs> displayCharityLogs();


}
