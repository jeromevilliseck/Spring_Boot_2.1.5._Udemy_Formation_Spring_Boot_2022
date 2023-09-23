package com.udemy.service;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepositoryInterface;

public class InvoiceServiceMichel implements InvoiceServiceInterface {
    private static long lastNumber=112L;

    private InvoiceRepositoryInterface invoiceRepositoryMichel;
    public void createInvoice(Invoice invoice){
        invoice.setNumber("INV_"+(++lastNumber));
        invoiceRepositoryMichel.create(invoice);
    }
}
