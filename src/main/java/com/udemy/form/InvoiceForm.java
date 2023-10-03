package com.udemy.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class InvoiceForm {
    private String number;
    @NotBlank(message = "nom obligatoire")
    private String customerName;
    //Utiliser @Pattern(regexp = "") pour respecter un format
    @Size(min=10,max=13, message = "n de commande entre 10 et f13 elements")
    private String orderNumber;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
