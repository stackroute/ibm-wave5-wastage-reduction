package com.stackroute.charityserver.repository;

import com.stackroute.charityserver.domain.CharityLogs;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharityLogsRepository extends MongoRepository<CharityLogs,Integer> {
}
