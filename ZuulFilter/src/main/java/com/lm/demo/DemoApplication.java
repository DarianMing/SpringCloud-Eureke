package com.lm.demo;

import com.lm.demo.filter.PassWordFilter;
import com.lm.demo.filter.TokerFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class DemoApplication {

    @Bean
    public TokerFilter tokerFilter () {
        return new TokerFilter();
    }

    @Bean
    public PassWordFilter passWordFilter () {
        return new PassWordFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

