package com.udemy.service;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepositoryInterface;

import java.util.List;

public interface InvoiceServiceInterface {
    Invoice createInvoice(Invoice invoice);
    List<Invoice> getInvoiceList();
    Invoice getInvoiceByNumber(String number);
}
