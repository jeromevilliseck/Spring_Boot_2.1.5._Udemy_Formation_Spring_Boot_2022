package com.udemy.service;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepository;

public class InvoiceServiceMichel {
    private static long lastNumber=112L;

    private InvoiceRepository invoiceRepository = new InvoiceRepository();
    public void createInvoice(Invoice invoice){
        invoice.setNumber("INV_"+(++lastNumber));
        invoiceRepository.create(invoice);
    }
}
