package com.stackroute.charityserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "charityLogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharityLogs {

    @Id
    private String id;

    private Date date;

    private int required;

    private int recieved;

    private int rating;
}
