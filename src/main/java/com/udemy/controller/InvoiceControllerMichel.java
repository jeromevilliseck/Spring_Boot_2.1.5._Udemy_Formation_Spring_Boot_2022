package com.udemy.controller;

import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceMichel;

public class InvoiceControllerMichel {
    public void createInvoiceUsingWebForm() {
        String customerName = "Tesla";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        InvoiceServiceMichel invoiceService = new InvoiceServiceMichel();
        invoiceService.createInvoice(invoice);
    }
}
