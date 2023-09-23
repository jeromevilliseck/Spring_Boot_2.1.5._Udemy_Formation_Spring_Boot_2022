package com.udemy;

import com.udemy.controller.InvoiceControllerInterface;
import com.udemy.controller.InvoiceControllerKeyboard;
import com.udemy.controller.InvoiceControllerDouchette;
import com.udemy.controller.InvoiceControllerWeb;
import com.udemy.repository.InvoiceRepositoryInterface;
import com.udemy.repository.InvoiceRepositoryMemory;
import com.udemy.repository.InvoiceRepositoryDatabase;
import com.udemy.service.InvoiceServiceInterface;
import com.udemy.service.InvoiceServiceNumber;
import com.udemy.service.InvoiceServicePrefix;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Quel est le type de controleur que vous souhaitez utiliser (keyboard, Douchette, Web)");
        Scanner sc = new Scanner(System.in);
        String controleurType = sc.nextLine();
        System.out.println("Quel est le type de service (number, prefix) ?");
        String serviceType = sc.nextLine();
        System.out.println("Quel est le type de repository (memory, database) ?");
        String repositoryType = sc.nextLine();

        InvoiceControllerInterface invoiceController;
        InvoiceServiceInterface invoiceService;
        InvoiceRepositoryInterface invoiceRepository;

        switch (controleurType) {
            case "keyboard":
                invoiceController = new InvoiceControllerKeyboard();
                break;
            case "web":
                invoiceController = new InvoiceControllerWeb();
                break;
            case "douchette":
                invoiceController = new InvoiceControllerDouchette();
                break;
            default:
                invoiceController = new InvoiceControllerWeb();
        }
        switch (controleurType) {
            case "number":
                invoiceService = new InvoiceServiceNumber();
                break;
            case "prefix":
                invoiceService = new InvoiceServicePrefix();
                break;
        }
        switch (repositoryType) {
            case "memory":
                invoiceRepository = new InvoiceRepositoryMemory();
                break;
            case "database":
                invoiceRepository = new InvoiceRepositoryDatabase();
                break;
        }
        invoiceController.createInvoice();
    }
}
