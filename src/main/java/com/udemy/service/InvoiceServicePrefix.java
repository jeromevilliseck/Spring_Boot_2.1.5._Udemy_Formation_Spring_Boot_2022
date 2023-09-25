package com.udemy.service;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class InvoiceServicePrefix implements InvoiceServiceInterface {
    @Value("124")
    private long lastNumber;
    @Value("NUM_")
    private String prefix;
    @Autowired
    private InvoiceRepositoryInterface invoiceRepositoryMichel;

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepositoryMichel) {
        this.invoiceRepositoryMichel = invoiceRepositoryMichel;
    }

    public void createInvoice(Invoice invoice){
        invoice.setNumber(prefix+(++lastNumber));
        invoiceRepositoryMichel.create(invoice);
    }
}
