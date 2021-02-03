package com.mohyehia.openshift.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Log4j2
public class HomeController {
    @GetMapping
    public String helloFromDev() {
        log.info("HomeController :: helloFromDev :: start");
        return "Hello from dev branch!";
    }
}
