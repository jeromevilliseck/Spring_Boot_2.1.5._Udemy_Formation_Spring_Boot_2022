package com.udemy.service.number;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepositoryInterface;
import com.udemy.service.InvoiceServiceInterface;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {
    private final InvoiceRepositoryInterface invoiceRepository;

    @Autowired
    public InvoiceServiceNumber(@Qualifier("invoiceRepositoryInterface") InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice createInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {
        Iterable<Invoice> invoices = invoiceRepository.findAll();
        //Initialise le customer de chaque facture
        invoices.forEach(invoice -> Hibernate.initialize(invoice.getCustomer()));
        return invoices;
    }

    //Plutot que faire un retour Optionnal<Invoice>, on lance un no such element exception si on ne trouve pas de facture
    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.findById(number).orElseThrow();
    }
}
