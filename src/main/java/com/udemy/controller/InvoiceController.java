package com.udemy.controller;

import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceService;

import java.util.Scanner;

public class InvoiceController {
    public void createInvoiceUsingConsole() {
        System.out.println( "WHat is customer name" );
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        InvoiceService invoiceService = new InvoiceService();
        invoiceService.createInvoice(invoice);
    }
}
