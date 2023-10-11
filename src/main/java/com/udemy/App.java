package com.udemy;

import com.udemy.controller.InvoiceControllerInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class App {
    /**
     *
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        //Bloc de test de la connexion SQL
        DataSource ds = context.getBean(DataSource.class);
        Connection conn = null;
        try {
            conn = ds.getConnection();
            System.out.println("connect ok");
            ResultSet rs = conn.createStatement().executeQuery("SELECT INVOICE_NUMBER, CUSTOMER_NAME FROM INVOICE");
            while (rs.next()){
                System.out.println(rs.getLong("INVOICE_NUMBER") + " | " + rs.getString("CUSTOMER_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}