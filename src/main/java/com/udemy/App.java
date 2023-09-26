package com.udemy;

import com.udemy.controller.InvoiceControllerInterface;
import com.udemy.service.prefix.InvoiceServicePrefix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
//base package n'est pas obligatoire car spring scanne à partir de l'emplacement de cette classe et des sous packages
@ComponentScan
@PropertySource("classpath:application.properties")
public class App {
    public static void main(String[] args) {
        //On indique ou se situe la configuration pour l'IoC et la DI
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        InvoiceControllerInterface invoiceControllerInterface = context.getBean(InvoiceControllerInterface.class);
        invoiceControllerInterface.createInvoice();
    }
}
