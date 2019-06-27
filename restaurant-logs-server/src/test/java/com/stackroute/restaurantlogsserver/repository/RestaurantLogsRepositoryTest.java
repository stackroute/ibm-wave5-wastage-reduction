package com.stackroute.restaurantlogsserver.repository;

import com.stackroute.restaurantlogsserver.domain.RestaurantLogs;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class RestaurantLogsRepositoryTest {
    @Autowired
    private RestaurantLogsRepository restaurantLogRepository;

    List<RestaurantLogs> list = null;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testgetAllRestaurantLog(){
//        restaurantLogRepository.save(restaurantLog);
        list = restaurantLogRepository.findAll();
        System.out.println(list.get(0));
        Assert.assertEquals(2334,list.get(0).getRestaurantlogid());

    }
}