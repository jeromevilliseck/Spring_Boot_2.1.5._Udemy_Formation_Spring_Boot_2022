package com.udemy.api;

import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceApi {
    @Autowired
    private final InvoiceServiceInterface service;

    public InvoiceApi(InvoiceServiceInterface service) {
        this.service = service;
    }

    @GetMapping("")
    @ResponseBody
    public List<Invoice> get(){
        return service.getInvoiceList();
    }

    @GetMapping("/{id}")
    @ResponseBody //Permet de convertir Invoice en JSON -> Spring boot starter web -> Spring boot starter JSON
    public Invoice get(@PathVariable("id") String number){
        return service.getInvoiceByNumber(number);
    }

    @GetMapping("/create")
    @ResponseBody //RequestBody va transformer du JSON ou autre en Objet Entité correspondant
    public Invoice post(@RequestBody Invoice invoice){
        return service.createInvoice(invoice);
    }
}
