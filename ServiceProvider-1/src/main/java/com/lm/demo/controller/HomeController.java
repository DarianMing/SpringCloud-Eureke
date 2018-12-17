package com.lm.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${server.port}")
    String port;

    @GetMapping("/")
    @ResponseBody
    public String home () {
        return "hello World , port: " + port;
    }
}
