package com.intuit.peerpay_api.model;

import java.util.UUID;

public class PayeeResponse {
    private UUID payeeId;
    private String name;
    private String email;

    public PayeeResponse() {
    }

    public PayeeResponse(UUID userId, String name, String email) {
        this.payeeId = userId;
        this.name = name;
        this.email = email;
    }

    public UUID getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
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
}
