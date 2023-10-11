package com.udemy.repository.database;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository donne accès à un jdbc template
@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {
    @Autowired
    public InvoiceRepositoryDatabase(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }
    //Le jdbc template va exploiter la datasource basée dans le fichier application.properties
    private final JdbcTemplate jdbcTemplate;


    public void create(Invoice invoice){
        System.out.println("DB -> Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName());
    }

    /**
     *  paramètres de la méthode query
     *  1. Requête SQL
     *  2. objet RowMapper, classe permettant d'itérer sur le resultset et de fabriquer des objets en conséquence, ce qu'on ferait avec du jdbc natif
     */

    @Override
    public List<Invoice> list() {
        //Créer une nouvelle facture sur la base de la ligne de resultset
        return jdbcTemplate.query("SELECT INVOICE_NUMBER, CUSTOMER_NAME FROM INVOICE",
                (rs, rowNum) -> new Invoice(String.valueOf(rs.getLong("INVOICE_NUMBER")), rs.getString("CUSTOMER_NAME")));
    }

    /*Méthode retournant un objet
    1. requete sql avec ? pour les paramètres
    2. objets à mettre a la place des paramètres ?
     */
    @Override
    public Invoice getInvoiceById(String number) {
        return jdbcTemplate.queryForObject("SELECT INVOICE_NUMBER, CUSTOMER_NAME, ORDER_NUMBER FROM INVOICE WHERE INVOICE_NUMBER = ?",
                new Object[]{number},
                (rs, rowNum) -> new Invoice(String.valueOf(rs.getLong("INVOICE_NUMBER")), rs.getString("CUSTOMER_NAME"), rs.getString("ORDER_NUMBER")));
    }
}
