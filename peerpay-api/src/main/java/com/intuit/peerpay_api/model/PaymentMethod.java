package com.intuit.peerpay_api.model;

import java.util.UUID;

public class PaymentMethod {
    private UUID methodId;
    private String displayName;

    public PaymentMethod() {
    }

    public PaymentMethod(UUID methodId, String displayName) {
        this.methodId = methodId;
        this.displayName = displayName;
    }

    public UUID getMethodId() {
        return methodId;
    }

    public void setMethodId(UUID methodId) {
        this.methodId = methodId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
