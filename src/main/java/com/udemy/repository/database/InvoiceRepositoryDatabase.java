package com.udemy.repository.database;

import com.udemy.entity.Invoice;
import com.udemy.repository.InvoiceRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@Repository donne accès à un jdbc template
@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {
    @Autowired
    public InvoiceRepositoryDatabase(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }
    //Le jdbc template va exploiter la datasource basée dans le fichier application.properties
    private final JdbcTemplate jdbcTemplate;


    public Invoice create(Invoice invoice){
        KeyHolder kh = new GeneratedKeyHolder();

        //MISE A JOUR
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO INVOICE(CUSTOMER_NAME,ORDER_NUMBER) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, invoice.getCustomerName());
            ps.setString(2, invoice.getOrderNumber());
            return ps;
        }, kh);

        //RECUPERATION DE LA CLE AUTOGENEREE
        invoice.setNumber(Objects.requireNonNull(kh.getKey()).toString());
        return invoice;
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
