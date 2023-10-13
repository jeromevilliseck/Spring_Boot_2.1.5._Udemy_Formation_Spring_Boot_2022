package com.udemy.controller.keyboard;

import com.udemy.controller.InvoiceControllerInterface;
import com.udemy.entity.Customer;
import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;

import java.util.Scanner;

//@Controller
public class InvoiceControllerKeyboard implements InvoiceControllerInterface {
    //@Autowired
    private final InvoiceServiceInterface invoiceService;

    public InvoiceControllerKeyboard(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public String createInvoice(Invoice invoice) {
        System.out.println( "WHat is customer name" );
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        invoice = new Invoice();
        Customer customer = new Customer(customerName);
        invoice.setCustomer(customer);
        invoiceService.createInvoice(invoice);
        return null;
    }
}
