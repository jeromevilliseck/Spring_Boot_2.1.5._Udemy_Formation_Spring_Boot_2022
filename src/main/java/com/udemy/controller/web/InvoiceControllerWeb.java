package com.udemy.controller.web;

import com.udemy.controller.InvoiceControllerInterface;
import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class InvoiceControllerWeb implements InvoiceControllerInterface {
    @Autowired
    private final InvoiceServiceInterface service;

    public InvoiceControllerWeb(InvoiceServiceInterface service) {
        this.service = service;
    }

    public void createInvoice() {
        String customerName = "Tesla";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        service.createInvoice(invoice);
    }

    //Spring utilise le request mapping pour trouver l'identifiant de la vue ici invoice-home
    //spring cherche une page invoice-home dans resources -> templates
    //L'annotation @ModelAttribute retourne un objet "invoices" aux vues
    @RequestMapping("/invoice-home")
    public @ModelAttribute("invoices") List<Invoice> displayHome(){
        System.out.println("La méthod display home a été invoquée");

        //Utilisation de la classe HttpServletRequest en paramètre
        List<Invoice> invoices = service.getInvoiceList();
        return invoices;
    }

    //{id} <-mapping-> @PathVariable("id") String number
    @RequestMapping("/invoice/{id}")
    public @ModelAttribute("/invoice/{id}") Invoice displayInvoice(@PathVariable("id") String number){
        System.out.println("La méthod displayInvoice a été invoquée");

        return null;
    }
}