package com.udemy.service;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepository;

public class InvoiceService {
    private static long lastNumber=0;

    private InvoiceRepository invoiceRepository = new InvoiceRepository();
    public void createInvoice(Invoice invoice){
        invoice.setNumber(String.valueOf(++lastNumber));
        invoiceRepository.create(invoice);
    }
}
