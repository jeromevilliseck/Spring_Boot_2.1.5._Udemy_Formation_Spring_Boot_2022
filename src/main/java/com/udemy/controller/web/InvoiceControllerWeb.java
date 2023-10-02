package com.udemy.controller.web;

import com.udemy.controller.InvoiceControllerInterface;
import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//On va avoir des url pour un controleur Invoice qui commencent systématiquement par /invoice
@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb implements InvoiceControllerInterface {
    @Autowired
    private final InvoiceServiceInterface service;

    public InvoiceControllerWeb(InvoiceServiceInterface service) {
        this.service = service;
    }

    //Avec @ModelAttribute Spring va instancier un objet invoice et le fournir en entrée
    @PostMapping( "")
    public String createInvoice(@ModelAttribute Invoice invoice) {
        service.createInvoice(invoice);
        return "invoice-created";
    }

    //Spring utilise le request mapping pour trouver l'identifiant de la vue ici invoice-home
    //spring cherche une page invoice-home dans resources -> templates
    //L'annotation @ModelAttribute retourne un objet "invoices" aux vues
    @GetMapping("/home")
    public String displayHome(Model model){
        System.out.println("La méthod displayHome a été invoquée");
        model.addAttribute("invoices", service.getInvoiceList());
        return "invoice-home";
    }

    //{id} <-mapping-> @PathVariable("id") String number
    @GetMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number, Model model){
        System.out.println("La méthod displayInvoice a été invoquée");
        model.addAttribute("invoice", service.getInvoiceByNumber(number));
        return "invoice-details";
    }

    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute Invoice invoice){
        return "invoice-create-form";
    }
}