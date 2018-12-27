package com.lm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//https://www.souyunku.com/2017/12/24/spring-cloud-config-bus-rabbitMQ/#spring-cloud-bus
//https://my.oschina.net/u/2263272/blog/1634010
//https://357029540.iteye.com/blog/2432558
//https://github.com/422518490/orderSystem
//postman 实现半自动刷新请求地址(POST)http://localhost:8888/actuator/bus-refresh
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

