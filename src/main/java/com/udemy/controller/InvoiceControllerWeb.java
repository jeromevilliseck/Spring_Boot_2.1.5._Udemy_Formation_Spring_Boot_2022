package com.udemy.controller;

import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//Annotation la plus générique @Component qui indique que le classe est un composant de l'architecture
//Une annotation fille de @Component est @Controller
//Spring traite ces deux annotations de la même manière
@Controller
public class InvoiceControllerWeb implements InvoiceControllerInterface {
    @Qualifier("invoiceServicePrefix")
    @Autowired
    private final InvoiceServiceInterface service;

    public InvoiceControllerWeb(@Qualifier("invoiceServicePrefix") InvoiceServiceInterface service) {
        this.service = service;
    }

    public void createInvoice() {
        String customerName = "Tesla";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        service.createInvoice(invoice);
    }
}
