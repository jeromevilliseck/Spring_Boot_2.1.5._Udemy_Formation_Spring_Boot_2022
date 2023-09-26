package com.udemy.controller.keyboard;

import com.udemy.controller.InvoiceControllerInterface;
import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class InvoiceControllerKeyboard implements InvoiceControllerInterface {
    @Qualifier("invoiceServiceNumber")
    @Autowired
    private final InvoiceServiceInterface invoiceService;

    public InvoiceControllerKeyboard(@Qualifier("invoiceServiceNumber") InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void createInvoice() {
        System.out.println( "WHat is customer name" );
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        invoiceService.createInvoice(invoice);
    }
}
