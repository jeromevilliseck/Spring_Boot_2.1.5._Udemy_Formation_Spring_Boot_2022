package com.udemy.service;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {
    private static long lastNumber=0;

    @Qualifier("invoiceRepositoryMemory")
    @Autowired
    private final InvoiceRepositoryInterface invoiceRepository;

    public InvoiceServiceNumber(@Qualifier("invoiceRepositoryMemory") InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void createInvoice(Invoice invoice){
        invoice.setNumber(String.valueOf(++lastNumber));
        invoiceRepository.create(invoice);
    }
}
