package com.udemy.controller;

import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;

public class InvoiceControllerWeb implements InvoiceControllerInterface {
    private InvoiceServiceInterface service;
    public void createInvoice() {
        String customerName = "Tesla";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        service.createInvoice(invoice);
    }

    public InvoiceServiceInterface getService() {
        return service;
    }

    public void setService(InvoiceServiceInterface service) {
        this.service = service;
    }
}
