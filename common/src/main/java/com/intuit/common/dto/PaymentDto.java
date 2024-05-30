package com.intuit.common.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentDto {
    private UUID userId;
    private UUID payeeId;
    private UUID paymentMethod;
    private BigDecimal amount;
    private String currency;
    private String idempotencyKey;
    private Long paymentTime;
    private Long serverTime;
    private UUID transactionId;

    public PaymentDto() {
        super();
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
    }

    public UUID getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(UUID paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public Long getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Long paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Long getServerTime() {
        return serverTime;
    }

    public void setServerTime(Long serverTime) {
        this.serverTime = serverTime;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "userId=" + userId +
                ", payeeId=" + payeeId +
                ", paymentMethod=" + paymentMethod +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", idempotencyKey='" + idempotencyKey + '\'' +
                ", paymentTime=" + paymentTime +
                ", serverTime=" + serverTime +
                ", transactionId=" + transactionId +
                '}';
    }
}
