package com.udemy.entity;
import jakarta.persistence.*;

@Entity
public class Invoice2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "INVOICE_GENERATION_AUTO", columnDefinition = "BIGINT")
    private String number;
    @Column(nullable = false, length = 50)
    private String customerNameAuto;
    @Column(length = 13)
    private String orderNumberAuto;
    @Column(length = 20)
    private Number telephone;

    public Invoice2() {}

    public Number getTelephone() {
        return telephone;
    }

    public void setTelephone(Number telephone) {
        this.telephone = telephone;
    }

    public Invoice2(String number, String customerNameAuto, Number telephone) {
        this.number = number;
        this.customerNameAuto = customerNameAuto;
        this.telephone = telephone;
    }

    public Invoice2(String number, String customerNameAuto, String orderNumberAuto, Number telephone) {
        this.number = number;
        this.customerNameAuto = customerNameAuto;
        this.orderNumberAuto = orderNumberAuto;
        this.telephone = telephone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerNameAuto() {
        return customerNameAuto;
    }

    public void setCustomerNameAuto(String customerName) {
        this.customerNameAuto = customerName;
    }

    public String getOrderNumberAuto() {
        return orderNumberAuto;
    }

    public void setOrderNumberAuto(String orderNumber) {
        this.orderNumberAuto = orderNumber;
    }
}
