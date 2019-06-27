package com.stackroute.restaurantlogsserver.service;

import com.stackroute.restaurantlogsserver.domain.RestaurantLogs;
import com.stackroute.restaurantlogsserver.exceptions.RestaurantIdAlreadyExistsException;
import com.stackroute.restaurantlogsserver.repository.RestaurantLogsRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class RestaurantLogsServiceTest {

    private RestaurantLogs restaurantLog;
    List<RestaurantLogs> list= null;
    @Mock
    RestaurantLogsRepository restaurantLogsRepository;
    @InjectMocks
    private RestaurantLogsServiceImpl restaurantLogsServiceImpl;

    @Before
    public void setUp() throws Exception {

        restaurantLog = new RestaurantLogs();
        restaurantLog.setRestaurantlogid(7);
        restaurantLog.setFoodavailable(90);
        restaurantLog.setRating("5stsr");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        String dateInString = "2019-02-03 10:08:02";
        Date date = formatter.parse(dateInString);
        restaurantLog.setLastUpdate(date);
        restaurantLog.setStatus("yes");
        list = new ArrayList();
        list.add(restaurantLog);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveRestaurantLog() throws Exception{

        when(restaurantLogsRepository.save((RestaurantLogs) any())).thenReturn(restaurantLog);
        RestaurantLogs savedrestaurantLog = restaurantLogsServiceImpl.saveRestaurantLog(restaurantLog);
        Assert.assertEquals(restaurantLog,savedrestaurantLog);
        System.out.println(savedrestaurantLog);
    }

    @Test(expected = RestaurantIdAlreadyExistsException.class)
    public void saveRestaurantLogTestFailure() throws RestaurantIdAlreadyExistsException {
        when(restaurantLogsRepository.save((RestaurantLogs) any())).thenReturn(null);
        RestaurantLogs savedRestaurantLog = restaurantLogsServiceImpl.saveRestaurantLog(restaurantLog);
        System.out.println("savedres"+savedRestaurantLog);
        Assert.assertEquals(restaurantLog,savedRestaurantLog);
    }

    @Test
    public void getAllRestaurantLog() throws Exception {
        restaurantLogsRepository.save(restaurantLog);
        //stubbing the mock to return specific data
        when(restaurantLogsRepository.findAll()).thenReturn(list);
        List<RestaurantLogs> userlist = restaurantLogsServiceImpl.getAllRestaurantLog();

        Assert.assertEquals(list,userlist);
    }
}