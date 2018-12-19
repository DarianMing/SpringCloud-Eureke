package com.lm.demo.controller;

import com.lm.demo.client.HomeClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HomeClient homeClient;

    @GetMapping("/hello")
    public String hello () {
        return homeClient.consumer();
    }
}
