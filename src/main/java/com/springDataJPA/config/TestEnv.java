package com.springDataJPA.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class TestEnv {

    @PostConstruct
    public void print() {
        System.out.println("DB_URL = " + System.getenv("DB_URL"));
        System.out.println("DB_USERNAME = " + System.getenv("DB_USERNAME"));
        System.out.println("DB_PASSWORD = " + System.getenv("DB_PASSWORD"));
    }
}