package com.udemy.controller;

import com.udemy.service.InvoiceServiceInterface;

public interface InvoiceControllerInterface {
    void createInvoice();

    void setInvoiceService(InvoiceServiceInterface invoiceService);
}
