package com.lm.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//@RefreshScope要加在声明@Controller声明的类上，
//否则refresh之后Conroller拿不到最新的值，会默认调用缓存
@RefreshScope
@RestController
public class HomeController {

    @Value("${content}")
    String content;

    @Value("${server.port}")
    String port;

    @GetMapping("/")
    public String home () {
        return "hello World , port: " + port + " ,content=" + content;
    }
}
