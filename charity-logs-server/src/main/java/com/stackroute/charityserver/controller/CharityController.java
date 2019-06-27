package com.stackroute.charityserver.controller;


import com.stackroute.charityserver.domain.CharityLogs;
import com.stackroute.charityserver.service.CharityLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1")
public class CharityController {
    @Autowired
    CharityLogsService charityLogsService;

    @Autowired
    public  CharityController(CharityLogsService charityLogsService)
    {
        this.charityLogsService=charityLogsService;
    }
    ResponseEntity responseEntity;

    @PostMapping("charity-logs")
    public ResponseEntity<?> saveCharityLogs (@RequestBody CharityLogs charityLogs) throws Exception
    {

        charityLogsService.saveCharityLogs(charityLogs);
        responseEntity=new ResponseEntity(charityLogs, HttpStatus.CREATED);
        return  responseEntity;
    }

    @GetMapping("charity-logs")
    public ResponseEntity displayCharityLogs()
    {
        return  new ResponseEntity(charityLogsService.displayCharityLogs(),HttpStatus.OK);
    }


}
