package com.udemy.controller;

import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;

import java.util.Scanner;

public class InvoiceController implements InvoiceControllerInterface {
    private InvoiceServiceInterface invoiceService;
    public void createInvoice() {
        System.out.println( "WHat is customer name" );
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        invoiceService.createInvoice(invoice);
    }

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }
}
