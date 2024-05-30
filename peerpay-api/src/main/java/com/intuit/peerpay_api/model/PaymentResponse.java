package com.intuit.peerpay_api.model;

import com.intuit.common.dto.PaymentDto;

import java.util.UUID;

public class PaymentResponse {
    private UUID transactionId;
    private Long createdAt;

    public PaymentResponse() {
    }

    public static PaymentResponse fromPaymentDto(PaymentDto paymentDto) {
        return new PaymentResponse(paymentDto.getTransactionId(), paymentDto.getServerTime());
    }


    public PaymentResponse(UUID transactionId, Long createdAt) {
        this.transactionId = transactionId;
        this.createdAt = createdAt;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
