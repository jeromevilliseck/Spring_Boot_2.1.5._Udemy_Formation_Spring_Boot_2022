package com.udemy;

import com.udemy.controller.InvoiceControllerInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //L'application context sert pour faire des programmes console ou shell qui s'arrêtent après une exécution
        ApplicationContext context = SpringApplication.run(App.class, args);
        InvoiceControllerInterface invoiceControllerInterface = context.getBean(InvoiceControllerInterface.class);
    }
}