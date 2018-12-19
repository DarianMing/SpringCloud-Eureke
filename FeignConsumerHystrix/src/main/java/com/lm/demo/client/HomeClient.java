package com.lm.demo.client;

import com.lm.demo.support.HystrixClientFallbackFactory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-provider" , fallbackFactory = HystrixClientFallbackFactory.class)
public interface HomeClient {

    @GetMapping(value = "/")
    String consumer();
}
