package com.udemy.service.number;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepositoryInterface;
import com.udemy.service.InvoiceServiceInterface;

import java.util.List;

//@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {
    private static long lastNumber=0;

    //@Autowired
    private final InvoiceRepositoryInterface invoiceRepository;

    public InvoiceServiceNumber(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void createInvoice(Invoice invoice){
        invoice.setNumber(String.valueOf(++lastNumber));
        invoiceRepository.create(invoice);
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
