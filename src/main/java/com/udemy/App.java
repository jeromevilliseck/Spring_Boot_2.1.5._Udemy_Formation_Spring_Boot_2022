package com.udemy;

import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories -> starter data jpa
@SpringBootApplication
@EnableJpaRepositories
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    //Nullification des proxy avec Jackson sur les entités
    @Bean
    public Hibernate6Module datatypeHibernateModule() {
        return new Hibernate6Module();
    }
}