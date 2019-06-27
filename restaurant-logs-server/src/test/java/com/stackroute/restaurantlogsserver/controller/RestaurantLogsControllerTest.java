package com.stackroute.restaurantlogsserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.restaurantlogsserver.domain.RestaurantLogs;
import com.stackroute.restaurantlogsserver.exceptions.RestaurantIdAlreadyExistsException;
import com.stackroute.restaurantlogsserver.service.RestaurantLogsService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantLogsController.class)
public class RestaurantLogsControllerTest {

    private RestaurantLogs restaurantLog;
    private List<RestaurantLogs> list =null;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RestaurantLogsService restaurantLogService;



    @Before
    public void setUp() throws Exception {
        restaurantLog = new RestaurantLogs();
        restaurantLog.setRestaurantlogid(23);
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
    public void saveRestaurantLogSuccess() throws Exception {
        when(restaurantLogService.saveRestaurantLog(restaurantLog)).thenReturn(restaurantLog);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/restaurant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(restaurantLog)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void saveRestaurantLogFailure() throws Exception {
        when(restaurantLogService.saveRestaurantLog(any())).thenThrow(RestaurantIdAlreadyExistsException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/restaurant")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(restaurantLog)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAllRestaurantLogs() throws Exception{
        when(restaurantLogService.getAllRestaurantLog()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/restaurant")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(restaurantLog)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

           }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}