package com.udemy.service;

import com.udemy.entity.Invoice;

public class InvoiceService {
    private static long lastNumber=0;
    public void createInvoice(Invoice invoice){
        invoice.setNumber(String.valueOf(++lastNumber));
    }
}
