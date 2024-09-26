package com.colak.springtutorial.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")

@Slf4j
public class HelloController {

    // http://localhost:8080/api/hello/john
    @GetMapping(path = "/{userName}", produces = "application/json")
    String hello(@PathVariable String userName) {
        log.info("Example  info  message -> Received userName  {}", userName);
        log.debug("Example debug message -> Received userName {}", userName);
        log.error("Example error message -> not found userName {}", userName);
        return "hello " + userName;
    }
}
