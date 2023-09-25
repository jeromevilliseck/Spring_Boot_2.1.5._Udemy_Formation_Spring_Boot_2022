package com.udemy.controller;

import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface{
    @Qualifier("invoiceServiceNumber")
    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceControllerDouchette(@Qualifier("invoiceServiceNumber") InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void createInvoice() {
        System.out.println("Usage du scanner");
        //Entité
        Invoice invoice = new Invoice();
        invoice.setCustomerName("Virgin Galactic");
        invoiceService.createInvoice(invoice);
    }
}
