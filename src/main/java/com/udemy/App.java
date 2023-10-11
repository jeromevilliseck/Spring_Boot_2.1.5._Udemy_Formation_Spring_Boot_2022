package com.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories -> starter data jpa
@SpringBootApplication
@EnableJpaRepositories
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}