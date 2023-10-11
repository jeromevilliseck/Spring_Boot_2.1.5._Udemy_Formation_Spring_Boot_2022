package com.udemy;

import com.udemy.controller.InvoiceControllerInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

//@EnableJdbcRepositories -> starter data jdbc
@SpringBootApplication
@EnableJdbcRepositories
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}