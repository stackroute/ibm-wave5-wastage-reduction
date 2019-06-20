package com.stackroute.authenticationserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisteredController {
    @RequestMapping({ "/checkUser" })
    public String checkUser() {
        return "This is a registered User";
    }
}
