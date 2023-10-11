package com.udemy.connexions;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//Classe utile lorsque l'on veut se connecter à plusieurs bases de données sur un même projet
//Si une seule BDD, passer par spring.datasource.url, et désactiver cette classe
@Configuration
public class DataConfig {
    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver"); //Driver 2023 mysql com.mysql.cj.jdbc.Driver deprecated
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/invoise"); //Url JDBC + ajout du schema en fin d'url
        dataSourceBuilder.username("COURSSPRING");
        dataSourceBuilder.password("coursspring");
        return dataSourceBuilder.build();
    }
}
