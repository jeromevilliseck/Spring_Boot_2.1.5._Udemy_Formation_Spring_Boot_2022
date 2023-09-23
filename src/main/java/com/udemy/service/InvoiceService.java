package com.udemy.service;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepositoryInterface;

public class InvoiceService implements InvoiceServiceInterface {
    private static long lastNumber=0;

    private InvoiceRepositoryInterface invoiceRepository;
    public void createInvoice(Invoice invoice){
        invoice.setNumber(String.valueOf(++lastNumber));
        invoiceRepository.create(invoice);
    }
}
