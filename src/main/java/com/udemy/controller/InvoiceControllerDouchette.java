package com.udemy.controller;

import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoiceControllerDouchette implements InvoiceControllerInterface{
    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }
    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }
    private InvoiceServiceInterface invoiceService;
    @Override
    public void createInvoice() {
        System.out.println("Usage du scanner");
        //Entité
        Invoice invoice = new Invoice();
        invoice.setCustomerName("Virgin Galactic");
        invoiceService.createInvoice(invoice);
    }
}
