package com.stayhome.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StayhomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StayhomeApplication.class, args);
    }

    @GetMapping("/test")
        public String test(@RequestParam(value = "name", defaultValue = "user") String name) {
    return String.format("Hello %s!, your spring-boot app is running correctly", name);
    }
}
