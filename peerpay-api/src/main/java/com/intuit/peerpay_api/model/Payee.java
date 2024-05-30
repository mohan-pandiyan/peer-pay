package com.intuit.peerpay_api.model;

import java.util.List;
import java.util.UUID;

public class Payee {
    private UUID id;
    private String name;
    private String email;
    private List<PaymentMethod> paymentMethods;

    public Payee() {
    }

    public Payee(UUID id, String name, String email, List<PaymentMethod> paymentMethods) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.paymentMethods = paymentMethods;
    }

    public PayeeResponse toPayeeResponse() {
        return new PayeeResponse(id, name, email);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
