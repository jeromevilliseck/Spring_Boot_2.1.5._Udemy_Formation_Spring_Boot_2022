package com.udemy.service.prefix;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepositoryInterface;
import com.udemy.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class InvoiceServicePrefix implements InvoiceServiceInterface {
    @Value("${invoice.lastnumber}")
    private long lastNumber;
    @Value("${invoice.prefix}")
    private String prefix;

    private final InvoiceRepositoryInterface invoiceRepositoryMichel;

    //@Autowired
    public InvoiceServicePrefix(InvoiceRepositoryInterface invoiceRepositoryMichel) {
        this.invoiceRepositoryMichel = invoiceRepositoryMichel;
    }

    public Invoice createInvoice(Invoice invoice){
        invoice.setNumber(prefix+(++lastNumber));
        invoiceRepositoryMichel.save(invoice);
        return invoice;
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {
        return invoiceRepositoryMichel.findAll();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepositoryMichel.findById(number).orElseThrow();
    }
}
