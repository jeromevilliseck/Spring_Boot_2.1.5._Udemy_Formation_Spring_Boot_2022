package com.udemy.service.number;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepositoryInterface;
import com.udemy.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {
    private final InvoiceRepositoryInterface invoiceRepository;

    @Autowired
    public InvoiceServiceNumber(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice createInvoice(Invoice invoice){
        return invoiceRepository.create(invoice);
    }

    @Override
    public List<Invoice> getInvoiceList() {
        return invoiceRepository.list();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.getInvoiceById(number);
    }
}
