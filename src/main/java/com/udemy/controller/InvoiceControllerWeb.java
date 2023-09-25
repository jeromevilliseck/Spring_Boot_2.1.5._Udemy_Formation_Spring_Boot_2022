package com.udemy.controller;

import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

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
