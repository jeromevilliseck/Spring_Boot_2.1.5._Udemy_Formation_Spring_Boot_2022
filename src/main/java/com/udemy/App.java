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
        System.out.println("Quel est la classe de controleur que vous souhaitez utiliser (keyboard, Douchette, Web)");
        Scanner sc = new Scanner(System.in);
        String controleurClass = sc.nextLine();
        System.out.println("Quel est la classe de service (number, prefix) ?");
        String serviceClass = sc.nextLine();
        System.out.println("Quel est la classe de repository (memory, database) ?");
        String repositoryClass = sc.nextLine();

        InvoiceControllerInterface invoiceController = null;
        InvoiceServiceInterface invoiceService = null;
        InvoiceRepositoryInterface invoiceRepository = null;

        /*Ici APP ne changera plus
        Meme si ajout d'implementations ultérieures de services, controller, repository
        APP se charge d'instancier les composants de l'architecture (inversion de controle)
        APP et les mets en relation grâce à l'injection de dépendances
         */

        //Inversion de controle
        //1 APP Instancie les composants de l'architecture par reflexivité
        try {
            //Reflexivité java : instancier un objet sur la base d'un nom de class donné par l'utilisateur
            //Pour que ça marche il faut utiliser la classe chemin du package complet inclus
            invoiceController = (InvoiceControllerInterface) Class.forName(controleurClass).getDeclaredConstructor().newInstance();
            invoiceService = (InvoiceServiceInterface) Class.forName(serviceClass).getDeclaredConstructor().newInstance();
            invoiceRepository = (InvoiceRepositoryInterface) Class.forName(repositoryClass).getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //2 APP les mets en relation grace à l'injection de dépendance, (mets un service concret dans un controller concret par ex)
        invoiceController.setInvoiceService(invoiceService);
        invoiceService.setInvoiceRepository(invoiceRepository);
        invoiceController.createInvoice();
    }
}
