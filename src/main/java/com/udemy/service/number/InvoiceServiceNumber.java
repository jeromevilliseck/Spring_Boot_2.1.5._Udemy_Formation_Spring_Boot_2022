package com.udemy.service.number;

import com.udemy.entity.Invoice;
import com.udemy.repository.CustomerRepositoryInterface;
import com.udemy.repository.InvoiceRepositoryInterface;
import com.udemy.service.InvoiceServiceInterface;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {
    private final InvoiceRepositoryInterface invoiceRepository;
    private final CustomerRepositoryInterface customerRepository;

    @Autowired
    public InvoiceServiceNumber(@Qualifier("invoiceRepositoryInterface") InvoiceRepositoryInterface invoiceRepository,
                                @Qualifier("customerRepositoryInterface") CustomerRepositoryInterface customerRepository) {
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;
    }

    public Invoice createInvoice(Invoice invoice){
        customerRepository.save(invoice.getCustomer());
        return invoiceRepository.save(invoice);
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {
        return invoiceRepository.findAll();
    }

    //Plutot que faire un retour Optionnal<Invoice>, on lance un no such element exception si on ne trouve pas de facture
    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.findById(number).orElseThrow();
    }
}
