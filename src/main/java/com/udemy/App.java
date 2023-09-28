package com.udemy;

import com.udemy.controller.InvoiceControllerInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//spring-boot-starter-parent encapsule désormais spring-boot-autoconfigure, spring-context (pom.xml)
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class);
        InvoiceControllerInterface invoiceControllerInterface = context.getBean(InvoiceControllerInterface.class);
        invoiceControllerInterface.createInvoice();
    }
}