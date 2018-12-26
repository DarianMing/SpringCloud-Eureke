package com.lm.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SystemController
 * @Description TODO
 * @Author Admin
 * @DATE 2018/12/26 14:45
 **/
@RestController
public class SystemController {

    @Value("${content}")
    String content;

    @GetMapping("/")
    public String home () {
        return "content: " + content;
    }
}
