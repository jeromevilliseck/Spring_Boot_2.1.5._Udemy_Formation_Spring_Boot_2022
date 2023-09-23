package com.udemy;

import com.udemy.controller.InvoiceController;
import com.udemy.controller.InvoiceControllerChambouleToutMagasin2;
import com.udemy.controller.InvoiceControllerMichel;
import com.udemy.repository.InvoiceRepository;
import com.udemy.repository.InvoiceRepositoryInterface;
import com.udemy.repository.InvoiceRepositoryMichel;
import com.udemy.service.InvoiceService;
import com.udemy.service.InvoiceServiceInterface;
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

            //Injection de dépendance classique le controleur recois une implémentation concrete de service
            //On dit qu'on injecte le service dans le contrôleur
            InvoiceService invoiceService = new InvoiceService();
            invoiceController.setInvoiceService(invoiceService);

            //Injection du bon repository dans le bon service
            InvoiceRepository invoiceRepository = new InvoiceRepository();
            invoiceService.setInvoiceRepository(invoiceRepository);

            //La méthode peut donc fonctionner
            invoiceController.createInvoice();
        } else if (configuration == 2){
            InvoiceControllerMichel invoiceControllerMichel = new InvoiceControllerMichel();

            //Injections des dépendances
            InvoiceServiceMichel invoiceServiceMichel = new InvoiceServiceMichel();
            invoiceControllerMichel.setService(invoiceServiceMichel);

            InvoiceRepositoryMichel invoiceRepositoryMichel = new InvoiceRepositoryMichel();
            invoiceServiceMichel.setInvoiceRepositoryMichel(invoiceRepositoryMichel);

            invoiceControllerMichel.createInvoice();
        } else if (configuration == 3){
            //Branchement d'un repository 2 sur service 1, branchement service 1 sur controleur 2
            InvoiceControllerMichel invoiceControllerMichel = new InvoiceControllerMichel();
            InvoiceService invoiceService = new InvoiceService();
            invoiceControllerMichel.setService(invoiceService);

            InvoiceRepositoryMichel invoiceRepositoryMichel = new InvoiceRepositoryMichel();
            invoiceService.setInvoiceRepository(invoiceRepositoryMichel);
            invoiceControllerMichel.createInvoice();
        } else if (configuration == 4){
            //Branchement d'un repository 2 sur service 1, branchement service 1 sur controleur 3
            InvoiceControllerChambouleToutMagasin2 invoiceControllerChambouleToutMagasin2 = new InvoiceControllerChambouleToutMagasin2();
            InvoiceService invoiceService = new InvoiceService();
            invoiceControllerChambouleToutMagasin2.setInvoiceService(invoiceService);

            InvoiceRepositoryMichel invoiceRepositoryMichel = new InvoiceRepositoryMichel();
            invoiceService.setInvoiceRepository(invoiceRepositoryMichel);
            invoiceControllerChambouleToutMagasin2.createInvoice();
        }
        //Danger cette façon de brancher les repository sur les services et les services sur les controleurs selon les demandes client
        //peut créer des centaines de combinatoires

    }
}
