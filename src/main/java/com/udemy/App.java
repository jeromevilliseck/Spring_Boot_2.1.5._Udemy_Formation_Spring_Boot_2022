package com.udemy;

import com.udemy.controller.InvoiceControllerInterface;
import com.udemy.service.prefix.InvoiceServicePrefix;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

//Ne fonctionne pas en l'état avec les versions > 2 de spring-boot-autoconfigure (pom.xml) ,
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        InvoiceControllerInterface invoiceControllerInterface = context.getBean(InvoiceControllerInterface.class);
        invoiceControllerInterface.createInvoice();
    }
}