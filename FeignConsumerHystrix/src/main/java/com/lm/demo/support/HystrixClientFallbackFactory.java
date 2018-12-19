package com.lm.demo.support;

import com.lm.demo.client.HomeClient;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<HomeClient> {

    @Override
    public HomeClient create(Throwable throwable) {
        return ()-> "feign + hystrix , 服务提供者挂了！";
    }
}
