package com.jwt.jwtAuthentication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping("/welcome")
    public String welcome(){

        String text = "Testing the authorization";
        return text;
    }
    @RequestMapping("/getusers")
    public String getUsers(){
        return "{\"name\" : \"Dheeraj\"}";
    }
}
