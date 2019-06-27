package com.stackroute.restaurantlogsserver.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="restaurantLogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantLogs {
    @Id
    int restaurantlogid;
    int foodavailable;
//    int required;
    String status;
    String rating;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

}


