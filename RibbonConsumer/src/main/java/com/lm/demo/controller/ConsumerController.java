package com.lm.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 调用服务提供者的‘home’方法
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello () {
        return restTemplate.getForEntity("http://eureka-provider/" , String.class).getBody();
    }
}
