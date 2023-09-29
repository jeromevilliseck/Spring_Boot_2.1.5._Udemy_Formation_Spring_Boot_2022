package com.udemy.repository.database;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {
    private static List<Invoice> invoices = new ArrayList<>();

    public void create(Invoice invoice){
        invoices.add(invoice);
        System.out.println("DB -> Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName());
    }

    @Override
    public List<Invoice> list() {
        Invoice invoice1 = new Invoice();
        invoice1.setCustomerName("patick");
        invoice1.setNumber("1");
        Invoice invoice2 = new Invoice();
        invoice2.setCustomerName("EDF");
        invoice2.setNumber("2");
        return List.of(invoice1,invoice2);
    }
}
