package com.udemy.controller.scan;

import com.udemy.controller.InvoiceControllerInterface;
import com.udemy.entity.Customer;
import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;

//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {
    //@Autowired
    private final InvoiceServiceInterface invoiceService;

    public InvoiceControllerDouchette(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public String createInvoice(Invoice invoice) {
        System.out.println("Usage du scanner");
        //Entité
        invoice = new Invoice();
        Customer customer = new Customer("Virgin Galactic");
        invoice.setCustomer(customer);
        invoiceService.createInvoice(invoice);
        return null;
    }
}
