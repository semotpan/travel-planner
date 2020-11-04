package dev.srg.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"dev.srg"})
public class TestingRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestingRestApplication.class, args);
    }
}

