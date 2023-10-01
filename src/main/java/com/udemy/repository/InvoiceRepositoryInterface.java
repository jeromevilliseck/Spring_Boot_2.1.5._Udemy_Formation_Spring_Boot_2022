package com.udemy.repository;

import com.udemy.entity.Invoice;

import java.util.List;

public interface InvoiceRepositoryInterface {
    void create(Invoice invoice);
    List<Invoice> list();
    Invoice getInvoiceById(String number);
}
