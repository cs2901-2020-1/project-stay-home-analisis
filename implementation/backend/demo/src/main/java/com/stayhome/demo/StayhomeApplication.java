package com.stayhome.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StayhomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StayhomeApplication.class, args);
    }
}
