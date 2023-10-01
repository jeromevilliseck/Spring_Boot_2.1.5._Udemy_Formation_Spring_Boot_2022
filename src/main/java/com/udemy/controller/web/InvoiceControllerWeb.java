package com.udemy.controller.web;

import com.udemy.controller.InvoiceControllerInterface;
import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    public void createInvoice() {
        String customerName = "Tesla";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        service.createInvoice(invoice);
    }

    //Spring utilise le request mapping pour trouver l'identifiant de la vue ici invoice-home
    //spring cherche une page invoice-home dans resources -> templates
    //L'annotation @ModelAttribute retourne un objet "invoices" aux vues
    @RequestMapping("/home")
    public ModelAndView displayHome(){
        System.out.println("La méthod displayHome a été invoquée");
        ModelAndView mv = new ModelAndView("invoice-home");
        mv.addObject("invoices", service.getInvoiceList());
        return mv;
    }

    //{id} <-mapping-> @PathVariable("id") String number
    @RequestMapping("/{id}")
    public ModelAndView displayInvoice(@PathVariable("id") String number){
        System.out.println("La méthod displayInvoice a été invoquée");
        ModelAndView mv = new ModelAndView("invoice-details");
        mv.addObject("invoice", service.getInvoiceByNumber(number));
        return mv;
    }
}