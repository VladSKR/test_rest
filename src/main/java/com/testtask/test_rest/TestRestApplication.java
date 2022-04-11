package com.testtask.test_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.testtask.test_rest")
public class TestRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRestApplication.class, args);
    }

}
