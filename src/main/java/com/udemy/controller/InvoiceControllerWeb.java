package com.udemy.controller;

import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//Annotation la plus générique @Component qui indique que le classe est un composant de l'architecture
//Une annotation fille de @Component est @Controller
//Spring traite ces deux annotations de la même manière
@Controller
public class InvoiceControllerWeb implements InvoiceControllerInterface {
    @Autowired
    private InvoiceServiceInterface service;
    //L'annotation @Autowired permet de s'affranchir du setter
    //La visibilité est transgressée par l'onnotation qui intervient au niveau du bytecode
    //L'autowired peut etre placé sur le setter d'un service pour forcer spring a passer par le setter lors de la DI

    public void createInvoice() {
        String customerName = "Tesla";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        service.createInvoice(invoice);
    }
}
