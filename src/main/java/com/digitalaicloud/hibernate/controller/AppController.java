package com.digitalaicloud.hibernate.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/name")
    public String appName() {
        return appName;
    }
}
