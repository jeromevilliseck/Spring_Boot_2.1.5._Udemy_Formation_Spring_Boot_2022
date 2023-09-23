package com.udemy.repository;

import com.udemy.entity.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepositoryMemory implements InvoiceRepositoryInterface {
    private static List<Invoice> invoices = new ArrayList<>();

    public void create(Invoice invoice){
        invoices.add(invoice);
        System.out.println("MEM -> Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName());
    }
}
