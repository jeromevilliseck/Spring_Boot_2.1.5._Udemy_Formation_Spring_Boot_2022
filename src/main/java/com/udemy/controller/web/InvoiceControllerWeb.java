package com.udemy.controller.web;

import com.udemy.controller.InvoiceControllerInterface;
import com.udemy.entity.Invoice;
import com.udemy.form.InvoiceForm;
import com.udemy.service.InvoiceServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//On va avoir des url pour un controleur Invoice qui commencent systématiquement par /invoice
@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb {
    @Autowired
    private final InvoiceServiceInterface service;

    public InvoiceControllerWeb(InvoiceServiceInterface service) {
        this.service = service;
    }

    //Tjrs placer l'objet BindingResult après le dernier model attribute
    @PostMapping( "")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult results) {
        if (results.hasErrors()){
            //Permet de rester sur le formulaire en cas d'erreurs sur la page, règles en lien avec @Valid dans InvoiceForm
            return "invoice-create-form";
        }
        Invoice invoice = new Invoice();
        invoice.setCustomerName(invoiceForm.getCustomerName());
        invoice.setOrderNumber(invoiceForm.getOrderNumber());
        service.createInvoice(invoice);

        return "invoice-created";
    }

    @GetMapping("/home")
    public String displayHome(Model model){
        System.out.println("La méthod displayHome a été invoquée");
        model.addAttribute("invoices", service.getInvoiceList());
        return "invoice-home";
    }

    @GetMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number, Model model){
        System.out.println("La méthod displayInvoice a été invoquée");
        model.addAttribute("invoice", service.getInvoiceByNumber(number));
        return "invoice-details";
    }

    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice){
        return "invoice-create-form";
    }
}