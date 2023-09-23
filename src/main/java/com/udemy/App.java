package com.udemy;

import com.udemy.controller.InvoiceController;
import com.udemy.controller.InvoiceControllerMichel;
import com.udemy.entity.Invoice;
import com.udemy.service.InvoiceService;
import com.udemy.service.InvoiceServiceMichel;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Dans quelle configuration etes vous");
        Scanner sc = new Scanner(System.in);
        int configuration = sc.nextInt();
        if (configuration == 1){
            InvoiceController invoiceController = new InvoiceController();
            invoiceController.createInvoiceUsingConsole();
        } else if (configuration == 2){
            InvoiceControllerMichel invoiceControllerMichel = new InvoiceControllerMichel();
            invoiceControllerMichel.createInvoiceUsingWebForm();
        }

    }
}
