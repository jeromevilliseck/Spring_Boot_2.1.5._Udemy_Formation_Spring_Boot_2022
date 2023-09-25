package com.udemy;

import com.udemy.controller.InvoiceControllerInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //Instancie un conteneur léger sur la base d'un fichier xml qui se trouve dans mon classpath en lisant le fichier
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Le context à été mis en mémoire, on peut récupérer un bean par son id ou par le nom de classe
        //Avec le polymorphisme on récupère des classes d'héritage, donc des interfaces
        InvoiceControllerInterface invoiceController = context.getBean(InvoiceControllerInterface.class);
        //L'injection de dépendance à été faite dans le fichier de configuration
        invoiceController.createInvoice();
    }
}
