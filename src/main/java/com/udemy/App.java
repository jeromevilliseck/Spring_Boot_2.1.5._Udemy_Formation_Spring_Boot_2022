package com.udemy;

import com.udemy.controller.InvoiceControllerInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.udemy.controller.scan", "com.udemy.service.number", "com.udemy.repository.database"})
@PropertySource("classpath:application.properties")
public class App {
    public static void main(String[] args) {
        //On indique ou se situe la configuration pour l'IoC et la DI
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        InvoiceControllerInterface invoiceControllerInterface = context.getBean(InvoiceControllerInterface.class);
        invoiceControllerInterface.createInvoice();
    }
}
