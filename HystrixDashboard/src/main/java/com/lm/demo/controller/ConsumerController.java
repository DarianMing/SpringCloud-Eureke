package com.lm.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConsumerController
 * @Description TODO
 * @Author Admin
 * @DATE 2018/12/25 16:07
 **/
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultStores")
    @GetMapping("/hello")
    public String hello () {
        return restTemplate.getForEntity("http://eureka-provider/" , String.class).getBody();
    }

    public String defaultStores () {
        return "feign + hystrix Dashboard , 提供者服务挂了";
    }

}
