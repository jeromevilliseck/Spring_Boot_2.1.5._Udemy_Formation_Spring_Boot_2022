package com.udemy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.udemy.controller.scan", "com.udemy.service.number", "com.udemy.repository.database"})
@PropertySource("classpath:application.properties")
public class AppConfig {
}
